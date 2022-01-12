package org.hustar.artfarm.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

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
	private final EntityManager em;
	
	@Override
	public List<ExhibitionPeriodResponseDto> getPeriod() {

		ExhibitionPeriod entity = em.find(ExhibitionPeriod.class, 1L);
		System.out.println("entity > "+ entity.getExhibition().getDiscription());
		return null;
		
	}

}
