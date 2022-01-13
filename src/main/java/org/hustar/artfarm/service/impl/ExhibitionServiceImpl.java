package org.hustar.artfarm.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hustar.artfarm.domain.exhibition.Exhibition;
import org.hustar.artfarm.domain.exhibition.ExhibitionRepository;
import org.hustar.artfarm.domain.period.ExhibitionPeriod;
import org.hustar.artfarm.domain.period.ExhibitionPeriodRepository;
import org.hustar.artfarm.dto.exhibition.ExhibitionResponseDto;
import org.hustar.artfarm.dto.exhibition.ExhibitionSaveUpdateRequestDto;
import org.hustar.artfarm.service.ExhibitionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExhibitionServiceImpl implements ExhibitionService {

	private final ExhibitionRepository exhibitionRepository;
	private final ExhibitionPeriodRepository exhPeriodRepository;

	@Override
	public Page<ExhibitionResponseDto> getExhibitionList(Pageable pageable) {
		Page<ExhibitionResponseDto> exhibitionList = exhibitionRepository.findAllByOrderByExhibitionIdxDesc(pageable)
				.map(entity -> new ExhibitionResponseDto(entity));

		return exhibitionList;
	}

	@Override
	public Page<ExhibitionResponseDto> getExhibitionListByDate(LocalDate date, Pageable pageable) {


//		LocalDateTime date1 = LocalDateTime.of(2022, 1, 12, 0, 0);

		List<ExhibitionPeriod> exhList = exhPeriodRepository.findExhibitionByDate(date);
		Set<Exhibition> exhSet = new HashSet<Exhibition>();

//		중복 처리 후, getExhibition responsDto로 변환.
		exhList.forEach(entity -> exhSet.add(entity.getExhibition()));
		exhSet.forEach(entity -> new ExhibitionResponseDto(entity));

		List<ExhibitionResponseDto> responseList = new ArrayList<ExhibitionResponseDto>();
		exhSet.forEach(response -> responseList.add(new ExhibitionResponseDto(response)));

//		List 를 Page로 바꾸기.
		int start = (int) pageable.getOffset();
		int end = Math.min((start + pageable.getPageSize()), responseList.size());
		Page<ExhibitionResponseDto> page = 
				new PageImpl<ExhibitionResponseDto>(responseList.subList(start, end),pageable, responseList.size());

		return page;
	}

	@Override
	public ExhibitionResponseDto getExhibition(Long exhibitionIdx) {
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

		exhibition.update(dto.getTitle(), dto.getSubTitle(), dto.getDiscription(), dto.getAuthor(), dto.getCategory(),
				dto.getPlace(), dto.getUrl(), dto.isOnOff(), dto.getThumbnail(),dto.getExhPeriod());
		return exhibitionIdx;
	}

	@Override
	public Long deleteExhibition(Long exhibitionIdx) {
		exhibitionRepository.deleteById(exhibitionIdx);
		return exhibitionIdx;
	}

}
