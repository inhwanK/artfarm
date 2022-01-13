package org.hustar.artfarm.service;

import java.util.List;

import org.hustar.artfarm.dto.exhibition.ExhibitionResponseDto;
import org.hustar.artfarm.dto.period.ExhibitionPeriodResponseDto;

public interface ExhibitionPeriodService {

	public List<ExhibitionResponseDto> getPeriod();
}
