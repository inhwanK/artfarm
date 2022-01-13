package org.hustar.artfarm.service.impl;


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
import org.hustar.artfarm.dto.period.ExhibitionPeriodResponseDto;
import org.hustar.artfarm.service.ExhibitionPeriodService;
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
	public List<ExhibitionResponseDto> getPeriod() {

		Exhibition entity = em.find(Exhibition.class, 1L);
		ExhibitionPeriod entity1 = em.find(ExhibitionPeriod.class, 1L);
		
		LocalDateTime date = LocalDateTime.of(2022, 1, 12, 0, 0);
		
		System.out.println("date time > "+date);
		System.out.println("date > "+date.toLocalDate());
		List<ExhibitionPeriod> list = new ArrayList<ExhibitionPeriod>(); 
		list = exhibitionPeriodRepository.findByDate(date.toLocalDate());
		
		
//		Set 을 이용한 중복 처리.
		List<ExhibitionPeriod> exhList = new ArrayList<ExhibitionPeriod>(); 
		exhList = exhibitionPeriodRepository.findExhibitionByDate(date.toLocalDate());
		exhList.forEach(it -> System.out.println("exhibition > "+ it));
		
		Set<Long> exhSet = new HashSet<Long>();
		Set<Exhibition> set = new HashSet<Exhibition>();
		
		exhList.forEach(i -> exhSet.add(i.getExhibition().getExhibitionIdx()));
		exhList.forEach(i -> set.add(i.getExhibition()));
		exhSet.forEach(i -> System.out.println("중복 처리 > "+ i));
		set.forEach(i -> System.out.println("중복 처리 > "+ i));
		
		set.forEach(i -> new ExhibitionResponseDto(i));
		List<ExhibitionResponseDto> l = new ArrayList<ExhibitionResponseDto>();
//		l.add = set.toArray();
		
		set.forEach(i -> l.add(new ExhibitionResponseDto(i)));
		
		
		System.out.println("기간으로 전시회 검색.  > "+ entity1.getExhibition().getExhibitionIdx());
		System.out.println("기간으로 전시회 검색.  > "+ list.get(0).getExhibition().getExhibitionIdx());
		System.out.println("기간으로 전시회 검색.  > "+ list);
		list.forEach(it -> System.out.println("exhibitionIdx > "+ it.getExhibition().getExhibitionIdx()));
		
		List<ExhibitionPeriodResponseDto> responseList = new ArrayList<ExhibitionPeriodResponseDto>();  
		list.forEach(it -> responseList.add(new ExhibitionPeriodResponseDto(it)));
		
		
		
//		System.out.println("기간으로 전시회 검색.  > "+ list.forEach(it -> it.getExhibition().get));
		
		System.out.println("전시회와 함께 기간 검색 > "+ entity.getExhPeriod().get(0).getEndTime());
		System.out.println("전시회와 함께 기간 검색 > "+ entity.getExhPeriod().get(1).getEndTime());
		System.out.println("전시회와 함께 기간 검색 > "+ entity.getExhPeriod().get(2).getEndTime());
		
		return l;
		
	}

}
