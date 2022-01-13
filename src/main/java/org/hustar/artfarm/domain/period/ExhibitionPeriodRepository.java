package org.hustar.artfarm.domain.period;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExhibitionPeriodRepository extends JpaRepository<ExhibitionPeriod, Long> {

//	Page<ExhibitionPeriod> findByDate(Pageable pageable, Date date);

	List<ExhibitionPeriod> findByDate(LocalDate localDate);

	List<ExhibitionPeriod> findExhibitionByDate(LocalDate localDate);
}
