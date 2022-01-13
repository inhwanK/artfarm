package org.hustar.artfarm.service.impl;

import javax.persistence.EntityManager;

import org.hustar.artfarm.domain.period.ExhibitionPeriodRepository;
import org.hustar.artfarm.service.ExhibitionPeriodService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExhibitionPeriodServiceImpl implements ExhibitionPeriodService {

	private final ExhibitionPeriodRepository exhPeriodRepository;

//	spring boot 에서는 application이 실행 될 때
//	EntityManager를 자동으로 bean 등록함.
	private final EntityManager em; // 필요없을 수도 있음.

	@Override
	public Long registerExhibitionPeriod() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
