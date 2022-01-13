package org.hustar.artfarm.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hustar.artfarm.domain.exhibition.Exhibition;
import org.hustar.artfarm.domain.period.ExhibitionPeriod;
import org.hustar.artfarm.domain.period.ExhibitionPeriodRepository;
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
	public List<ExhibitionPeriodResponseDto> getPeriod() {

		Exhibition entity = em.find(Exhibition.class, 1L);
		ExhibitionPeriod entity1 = em.find(ExhibitionPeriod.class, 1L);
		
		System.out.println("기간으로 전시회 검색.  > "+ entity1.getExhibition().getDiscription());
		
		System.out.println("전시회와 함께 기간 검색 > "+ entity.getExhPeriod().get(0).getEndTime());
		System.out.println("전시회와 함께 기간 검색 > "+ entity.getExhPeriod().get(1).getEndTime());
		System.out.println("전시회와 함께 기간 검색 > "+ entity.getExhPeriod().get(2).getEndTime());
		
		return null;
		
	}

}
