package org.hustar.artfarm.service.impl;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.hustar.artfarm.domain.exhibition.Exhibition;
import org.hustar.artfarm.domain.exhibition.ExhibitionRepository;
import org.hustar.artfarm.domain.file.ExhibitionFile;
import org.hustar.artfarm.domain.file.ExhibitionFileRepository;
import org.hustar.artfarm.domain.file.S3Uploader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExhibitionFileService implements org.hustar.artfarm.service.ExhibitionFileService {

	private final S3Uploader s3Uploader;
	private final ExhibitionRepository exhibitionRepository;
	private final ExhibitionFileRepository fileRepository;

	@Transactional
	@Override
	public Long uploadFileAndInfo(MultipartFile multipartFile, Long exhibitionIdx, String dirName) throws IOException {

		// dirName 지정

		String fileUrl = s3Uploader.upload(multipartFile, exhibitionIdx, dirName);

//		System.out.println("service에서 fileName 뽑아오기 2 > " + multipartFile.getOriginalFilename());
//		System.out.println("파일 용량 > " + multipartFile.getSize());
//
//		ExhibitionFileSaveRequestDto requestDto = new ExhibitionFileSaveRequestDto();
//		
//		requestDto.setExhibition(exhibitionRepository.findById(exhibitionIdx)
//				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + exhibitionIdx)));
//		requestDto.setFileName(multipartFile.getOriginalFilename());
//		requestDto.setFilePath(fileUrl);
//		requestDto.setFileSize(multipartFile.getSize() + "");
//		requestDto.setFileRegDate(LocalDateTime.now());
		
		Exhibition exhibition = exhibitionRepository.findById(exhibitionIdx)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + exhibitionIdx));

//		ExhibitionFile exhFileEntity = fileRepository.save(requestDto.toEntity());
		ExhibitionFile exhFileEntity = ExhibitionFile.builder()
				.exhibition(exhibition)
				.fileName(multipartFile.getOriginalFilename())
				.filePath(fileUrl)
				.fileSize(multipartFile.getSize()+"")
				.fileRegDate(LocalDateTime.now())
				.build();
		
		fileRepository.save(exhFileEntity);
		return exhFileEntity.getFileIdx();
	}

}
