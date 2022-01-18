package org.hustar.artfarm.domain.exhibition;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExhibitionRepository extends JpaRepository<Exhibition, Long> {

	Page<Exhibition> findAllByOrderByExhibitionIdxDesc(Pageable pageable);

//	and date(ep.date) = date(now())")
	Page<Exhibition> findAllByCategory(Category category, Pageable pageable);
}
