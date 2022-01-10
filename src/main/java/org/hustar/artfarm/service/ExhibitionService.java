package org.hustar.artfarm.service;

import org.hustar.artfarm.dto.exhibition.ExhibitionResponseDto;
import org.hustar.artfarm.dto.exhibition.ExhibitionSaveUpdateRequestDto;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

public interface ExhibitionService {
	
	public Page<ExhibitionResponseDto> getExhibitionList(Pageable pageable);
	
	public ExhibitionResponseDto getExhibition(Long exhibitionIdx);
	
	public Long registExhibition(ExhibitionSaveUpdateRequestDto dto);
	
	public Long updateExhibition(Long exhibitionIdx, ExhibitionSaveUpdateRequestDto dto);
	
	public Long deleteExhibition(Long exhibitionIdx);
}
