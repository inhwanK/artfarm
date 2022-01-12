package org.hustar.artfarm.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import org.hustar.artfarm.domain.exhibition.Exhibition;
import org.hustar.artfarm.domain.exhibition.ExhibitionRepository;
import org.hustar.artfarm.domain.period.ExhibitionPeriod;
import org.hustar.artfarm.domain.period.ExhibitionPeriodRepository;
import org.hustar.artfarm.dto.exhibition.ExhibitionResponseDto;
import org.hustar.artfarm.dto.exhibition.ExhibitionSaveUpdateRequestDto;
import org.hustar.artfarm.dto.period.ExhibitionPeriodResponseDto;
import org.hustar.artfarm.service.ExhibitionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExhibitionServiceImpl implements ExhibitionService {

	private final ExhibitionRepository exhibitionRepository;
	private final ExhibitionPeriodRepository exhPeriodRepository;
	private final EntityManager em;

	@Override
	public Page<ExhibitionResponseDto> getExhibitionList(Pageable pageable) {
		Page<ExhibitionResponseDto> exhibitionList = exhibitionRepository.findAllByOrderByExhibitionIdxDesc(pageable)
				.map(entity -> new ExhibitionResponseDto(entity));

		return exhibitionList;
	}

	@Override
	public Page<ExhibitionResponseDto> getExhibitionListByDate(Pageable pageable, Date date) {
//		Page<ExhibitionResponseDto> exhibitionList = exhPeriodRepository.findByDate(pageable, date)
//				.map(entity -> new ExhibitionResponseDto(entity));
		
//		List<ExhibitionPeriod> exhPeriodList = 
//		List<ExhibitionPeriodResponseDto> exhPeriodList = new ArrayList<ExhibitionPeriodResponseDto>();
		
//		Set<ExhibitionPeriodResponseDto> exhPeriodSet = new HashSet<ExhibitionPeriodResponseDto>();
		
//		exhPeriodRepository.findAllByDate(date)
//			.forEach(entity -> exhPeriodSet.add(new ExhibitionPeriodResponseDto(entity)));
		
//		exhPeriodSet.toArray().;
//		Page<ExhibitionPeriodResponseDto> exhPeriodList = 
//				new ExhibitionPeriodResponseDto(entity));
		/*
		슈도코드
		1. 오늘 날짜 일정 데이터 모두 뽑기
		2. 해당 데이터의 전시회로 responseDto
		
		*/
		return null;
	}

	@Override
	public ExhibitionResponseDto getExhibition(Long exhibitionIdx) {

//		Exhibition entity = em.find(Exhibition.class, exhibitionIdx);

		Exhibition entity = exhibitionRepository.findById(exhibitionIdx)
				.orElseThrow(() -> new IllegalArgumentException("해당 전시회 정보가 없습니다. id=" + exhibitionIdx));

		return new ExhibitionResponseDto(entity);
	}

	@Override
	public Long registerExhibition(ExhibitionSaveUpdateRequestDto dto) {

		return exhibitionRepository.save(dto.toEntity()).getExhibitionIdx();
	}

	@Override
	public Long updateExhibition(Long exhibitionIdx, ExhibitionSaveUpdateRequestDto dto) {
		Exhibition exhibition = exhibitionRepository.findById(exhibitionIdx)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + exhibitionIdx));

		exhibition.update(dto.getTitle(), dto.getSubTitle(), dto.getDiscription(), dto.getAuthor(),
				dto.getCategory(), dto.getPlace(), dto.getUrl(), dto.isOnOff(), dto.getThumbnail());
		return exhibitionIdx;
	}

	@Override
	public Long deleteExhibition(Long exhibitionIdx) {
		exhibitionRepository.deleteById(exhibitionIdx);
		return exhibitionIdx;
	}

}
