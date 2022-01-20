package org.hustar.artfarm.service.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hustar.artfarm.domain.exhibition.Exhibition;
import org.hustar.artfarm.domain.exhibition.ExhibitionRepository;
import org.hustar.artfarm.domain.file.ExhibitionFile;
import org.hustar.artfarm.domain.file.ExhibitionFileRepository;
import org.hustar.artfarm.domain.file.S3Uploader;
import org.hustar.artfarm.dto.file.ExhibitionFileResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExhibitionFileServiceImpl implements org.hustar.artfarm.service.ExhibitionFileService {

	private final S3Uploader s3Uploader;
	private final ExhibitionRepository exhibitionRepository;
	private final ExhibitionFileRepository fileRepository;

	@Transactional
	@Override
	public ExhibitionFileResponseDto getFile(Long fileIdx) {

		ExhibitionFile file = fileRepository.findById(fileIdx)
				.orElseThrow(() -> new IllegalArgumentException("해당 파일 정보가 없습니다. id=" + fileIdx));

		return new ExhibitionFileResponseDto(file);
	}

	@Transactional	
	@Override
	public List<ExhibitionFileResponseDto> getFileByExhibition(Long exhibitionIdx) {
		Exhibition exhibition = exhibitionRepository.findById(exhibitionIdx)
				.orElseThrow(() -> new IllegalArgumentException("해당 전시회 정보가 없습니다. id=" + exhibitionIdx));
		
		List<ExhibitionFile> entityList = fileRepository.findByExhibition(exhibition);
		
		
		List<ExhibitionFileResponseDto> responseList = new ArrayList<ExhibitionFileResponseDto>(); 
		entityList.forEach(entity -> responseList.add(new ExhibitionFileResponseDto(entity)));
		
		return responseList;
	}

	@Transactional
	@Override
	public Long uploadFileAndInfo(MultipartFile multipartFile, Long exhibitionIdx, String dirName) throws IOException {

		String fileUrl = s3Uploader.upload(multipartFile, exhibitionIdx, dirName);
		
		Exhibition exhibition = exhibitionRepository.findById(exhibitionIdx)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + exhibitionIdx));

		ExhibitionFile exhFileEntity = ExhibitionFile.builder()
				.exhibition(exhibition)
				.fileName(multipartFile.getOriginalFilename())
				.filePath(fileUrl)
				.fileSize(multipartFile.getSize() + "")
				.fileRegDate(LocalDateTime.now())
				.build();

		fileRepository.save(exhFileEntity);
		return exhFileEntity.getFileIdx();
	}

}
