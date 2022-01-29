package org.hustar.artfarm.domain.file;

import java.util.List;

import org.hustar.artfarm.domain.exhibition.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExhibitionFileRepository extends JpaRepository<ExhibitionFile, Long> {
	
	List<ExhibitionFile> findByExhibition(Exhibition exhibition);
}
