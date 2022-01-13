package org.hustar.artfarm.service;

import java.time.LocalDate;
import java.util.List;

import org.hustar.artfarm.dto.exhibition.ExhibitionResponseDto;
import org.hustar.artfarm.dto.period.ExhibitionPeriodResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExhibitionPeriodService {

	public Page<ExhibitionResponseDto> getExhibitionListByDate(LocalDate date, Pageable pageable);
}
