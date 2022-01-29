package org.hustar.artfarm.dto.file;

import java.time.LocalDateTime;

import org.hustar.artfarm.domain.file.ExhibitionFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExhibitionFileResponseDto {
	
	private Long fileIdx;
//	private Exhibition exhibition;
	private Long exhibitionIdx;
	private String fileName;
	private String filePath;
	private String fileSize;
	private LocalDateTime fileRegDate;
	
	public ExhibitionFileResponseDto(ExhibitionFile entity) {
		super();
		this.fileIdx = entity.getFileIdx();
		this.exhibitionIdx = entity.getExhibition().getExhibitionIdx();
		this.fileName = entity.getFileName();
		this.filePath = entity.getFilePath();
		this.fileSize = entity.getFileSize();
		this.fileRegDate = entity.getFileRegDate();
	}
	
	
}
