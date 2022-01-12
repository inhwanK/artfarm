package org.hustar.artfarm.domain.period;

import java.util.List;

import org.hustar.artfarm.domain.exhibition.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExhibitionPeriodRepository extends JpaRepository<ExhibitionPeriod, Long> {

	List<ExhibitionPeriod> findByExhibitionOrderByDate(Exhibition exhibition);
	
}
