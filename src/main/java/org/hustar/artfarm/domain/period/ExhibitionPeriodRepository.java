package org.hustar.artfarm.domain.period;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hustar.artfarm.domain.exhibition.Exhibition;
import org.hustar.artfarm.dto.exhibition.ExhibitionResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExhibitionPeriodRepository extends JpaRepository<ExhibitionPeriod, Long> {

//	Page<ExhibitionPeriod> findByDate(Pageable pageable, Date date);
	

	List<ExhibitionPeriod> findByDate(LocalDate localDate);
	
	List<ExhibitionPeriod> findExhibitionByDate(LocalDate localDate);
}
