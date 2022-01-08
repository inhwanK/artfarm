package org.hustar.artfarm.service.impl;

import org.hustar.artfarm.dto.exhibition.ExhibitionResponseDto;
import org.hustar.artfarm.dto.exhibition.ExhibitionSaveUpdateRequestDto;
import org.hustar.artfarm.service.ExhibitionService;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

public class ExhibitionServiceImpl implements ExhibitionService {

	@Override
	public Page<ExhibitionResponseDto> getExhibitionList(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExhibitionResponseDto getExhibition(Long exhibitionIdx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long registExhibition(ExhibitionSaveUpdateRequestDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long updateExhibition(Long exhibitionIdx, ExhibitionSaveUpdateRequestDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long deleteExhibition(Long exhibitionIdx) {
		// TODO Auto-generated method stub
		return null;
	}

}
