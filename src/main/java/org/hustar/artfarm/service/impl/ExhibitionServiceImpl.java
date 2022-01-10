package org.hustar.artfarm.service.impl;

import org.hustar.artfarm.domain.exhibition.Exhibition;
import org.hustar.artfarm.domain.exhibition.ExhibitionRepository;
import org.hustar.artfarm.dto.exhibition.ExhibitionResponseDto;
import org.hustar.artfarm.dto.exhibition.ExhibitionSaveUpdateRequestDto;
import org.hustar.artfarm.service.ExhibitionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExhibitionServiceImpl implements ExhibitionService {

	private final ExhibitionRepository exhibitionRepository;
	
	@Override
	public Page<ExhibitionResponseDto> getExhibitionList(Pageable pageable) {
		Page<ExhibitionResponseDto> exhibitionList =
				exhibitionRepository.findAllByOrderByExhibitionIdxDesc(pageable).map(entity -> new ExhibitionResponseDto(entity));
		
		return exhibitionList;
	}

	@Override
	public ExhibitionResponseDto getExhibition(Long exhibitionIdx) {
		Exhibition entity = exhibitionRepository.findById(exhibitionIdx)
				.orElseThrow(() -> new IllegalArgumentException("해당 전시회 정보가 없습니다. id="+ exhibitionIdx));
		return new ExhibitionResponseDto(entity);
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
