package org.hustar.artfarm.service.impl;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.hustar.artfarm.domain.exhibition.Exhibition;
import org.hustar.artfarm.domain.period.ExhibitionPeriod;
import org.hustar.artfarm.domain.period.ExhibitionPeriodRepository;
import org.hustar.artfarm.dto.exhibition.ExhibitionResponseDto;
import org.hustar.artfarm.service.ExhibitionPeriodService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExhibitionPeriodServiceImpl implements ExhibitionPeriodService {

	private final ExhibitionPeriodRepository exhibitionPeriodRepository;
	
//	spring boot 에서는 application이 실행 될 때
//	EntityManager를 자동으로 bean 등록함.
	private final EntityManager em; // 필요없을 수도 있음.
	
	@Override
	public Page<ExhibitionResponseDto> getExhibitionListByDate(LocalDate date, Pageable pageable) {
		
		LocalDateTime date1 = LocalDateTime.of(2022, 1, 12, 0, 0);
		
		
//		List<ExhibitionPeriod> list = new ArrayList<ExhibitionPeriod>(); 
//		list = exhibitionPeriodRepository.findByDate(date.toLocalDate());
		
		
//		Set 을 이용한 중복 처리.
		List<ExhibitionPeriod> exhList = exhibitionPeriodRepository.findExhibitionByDate(date1.toLocalDate());
//		exhList.forEach(it -> System.out.println("exhibition > "+ it));
		
		Set<Exhibition> exhSet = new HashSet<Exhibition>();
		
		exhList.forEach(i -> exhSet.add(i.getExhibition()));
		exhSet.forEach(i -> new ExhibitionResponseDto(i));
		
		List<ExhibitionResponseDto> responseList = new ArrayList<ExhibitionResponseDto>();
		exhSet.forEach(entity -> responseList.add(new ExhibitionResponseDto(entity)));
		

		int start = (int) pageable.getOffset();
		int end = Math.min((start + pageable.getPageSize()), responseList.size());
		
		Page<ExhibitionResponseDto> page = 
				new PageImpl<ExhibitionResponseDto>(responseList.subList(start, end), pageable, responseList.size());
		
		
//				new PageImpl<>(responseList.subList(0, responseList.size()), pageable, users.size());
//		Page<ExhibitionResponseDto> responsePage = 
				
				
//		
		
//		System.out.println("기간으로 전시회 검색.  > "+ entity1.getExhibition().getExhibitionIdx());
//		System.out.println("기간으로 전시회 검색.  > "+ list.get(0).getExhibition().getExhibitionIdx());
//		System.out.println("기간으로 전시회 검색.  > "+ list);
//		list.forEach(it -> System.out.println("exhibitionIdx > "+ it.getExhibition().getExhibitionIdx()));
//		
//		List<ExhibitionPeriodResponseDto> responseList = new ArrayList<ExhibitionPeriodResponseDto>();  
//		list.forEach(it -> responseList.add(new ExhibitionPeriodResponseDto(it)));
		
		
		
//		System.out.println("기간으로 전시회 검색.  > "+ list.forEach(it -> it.getExhibition().get));
		
//		System.out.println("전시회와 함께 기간 검색 > "+ entity.getExhPeriod().get(0).getEndTime());
//		System.out.println("전시회와 함께 기간 검색 > "+ entity.getExhPeriod().get(1).getEndTime());
//		System.out.println("전시회와 함께 기간 검색 > "+ entity.getExhPeriod().get(2).getEndTime());
		
		return page;
		
	}

}
