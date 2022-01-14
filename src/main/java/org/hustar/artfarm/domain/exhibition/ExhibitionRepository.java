package org.hustar.artfarm.domain.exhibition;


import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExhibitionRepository extends JpaRepository<Exhibition, Long> {
	
	Page<Exhibition> findAllByOrderByExhibitionIdxDesc(Pageable pageable);
	
//	and date(ep.date) = date(now())")
	@Query(value = "SELECT e FROM Exhibition e JOIN ExhibitionPeriod ep on ep.exhibitionIdx = e.exhibitionIdx"
			+ "WHERE e.category = :category")
	Page<Exhibition> findAllByCategoryOrderByExhibitionIdx(@Param("category") String category, Pageable pageable);
}
