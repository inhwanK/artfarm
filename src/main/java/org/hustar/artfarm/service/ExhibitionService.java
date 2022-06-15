package org.hustar.artfarm.service;

import java.time.LocalDate;

import org.hustar.artfarm.domain.exhibition.Category;
import org.hustar.artfarm.dto.exhibition.ExhibitionResponseDto;
import org.hustar.artfarm.dto.exhibition.ExhibitionSaveUpdateRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExhibitionService {

	Page<ExhibitionResponseDto> getExhibitionList(Pageable pageable);

	Page<ExhibitionResponseDto> getExhibitionListByDate(LocalDate date, Pageable pageable);

	Page<ExhibitionResponseDto> getExhibitionListByCategory(Category category, Pageable pageable);
	
	ExhibitionResponseDto getExhibition(Long exhibitionIdx);

	Long registerExhibition(ExhibitionSaveUpdateRequestDto dto);

	Long updateExhibition(Long exhibitionIdx, ExhibitionSaveUpdateRequestDto dto);

	Long deleteExhibition(Long exhibitionIdx);
}
