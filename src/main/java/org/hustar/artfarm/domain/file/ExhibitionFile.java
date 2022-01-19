package org.hustar.artfarm.domain.file;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hustar.artfarm.domain.exhibition.Exhibition;

import groovy.transform.builder.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@Entity
@Table(name="exhibition_file")
public class ExhibitionFile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fileIdx;
	
	@ManyToOne
	@JoinColumn(name = "exhibition_idx")
	private Exhibition exhibition;
	private String fileName;
	private String filePath;
	private String fileSize;
	private LocalDateTime fileRegDate;
	
	@Builder
	public ExhibitionFile(Long fileIdx, Exhibition exhibition, String fileName, String filePath, String fileSize,
			LocalDateTime fileRegDate) {
		super();
		this.fileIdx = fileIdx;
		this.exhibition = exhibition;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.fileRegDate = fileRegDate;
	}
	
	
}
