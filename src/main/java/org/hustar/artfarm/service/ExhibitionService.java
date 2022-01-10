package org.hustar.artfarm.service;

import org.hustar.artfarm.dto.exhibition.ExhibitionResponseDto;
import org.hustar.artfarm.dto.exhibition.ExhibitionSaveUpdateRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExhibitionService {
	
	public Page<ExhibitionResponseDto> getExhibitionList(Pageable pageable);
	
	public ExhibitionResponseDto getExhibition(Long exhibitionIdx);
	
	public Long registerExhibition(ExhibitionSaveUpdateRequestDto dto);
	
	public Long updateExhibition(Long exhibitionIdx, ExhibitionSaveUpdateRequestDto dto);
	
	public Long deleteExhibition(Long exhibitionIdx);
}
