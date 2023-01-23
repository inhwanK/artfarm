package org.hustar.artfarm.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hustar.artfarm.domain.exhibition.Exhibition;
import org.hustar.artfarm.domain.exhibition.ExhibitionRepository;
import org.hustar.artfarm.domain.file.ExhibitionFile;
import org.hustar.artfarm.domain.file.ExhibitionFileRepository;
import org.hustar.artfarm.dto.file.ExhibitionFileResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExhibitionFileService {

    private final ExhibitionRepository exhibitionRepository;
    private final ExhibitionFileRepository fileRepository;

    @Transactional
    public ExhibitionFileResponseDto getFile(Long fileIdx) {

        ExhibitionFile file = fileRepository.findById(fileIdx)
                .orElseThrow(() -> new IllegalArgumentException("해당 파일 정보가 없습니다. id=" + fileIdx));

        return new ExhibitionFileResponseDto(file);
    }

    @Transactional
    public List<ExhibitionFileResponseDto> getFileByExhibition(Long exhibitionIdx) {
        Exhibition exhibition = exhibitionRepository.findById(exhibitionIdx)
                .orElseThrow(() -> new IllegalArgumentException("해당 전시회 정보가 없습니다. id=" + exhibitionIdx));

        List<ExhibitionFile> entityList = fileRepository.findByExhibition(exhibition);


        List<ExhibitionFileResponseDto> responseList = new ArrayList<ExhibitionFileResponseDto>();
        entityList.forEach(entity -> responseList.add(new ExhibitionFileResponseDto(entity)));

        return responseList;
    }
}
