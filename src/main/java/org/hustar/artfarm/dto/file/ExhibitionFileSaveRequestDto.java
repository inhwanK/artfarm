package org.hustar.artfarm.dto.file;

import java.time.LocalDateTime;

import org.hustar.artfarm.domain.exhibition.Exhibition;
import org.hustar.artfarm.domain.file.ExhibitionFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExhibitionFileSaveRequestDto {

	private Exhibition exhibition;
	private String fileName;
	private String filePath;
	private String fileSize;
	private LocalDateTime fileRegDate;
	
	public ExhibitionFileSaveRequestDto(Exhibition exhibition, String fileName, String filePath, String fileSize,
			LocalDateTime fileRegDate) {
		super();
		this.exhibition = exhibition;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.fileRegDate = fileRegDate;
	}
	
	public ExhibitionFile toEntity() {
		return ExhibitionFile.buil  
	}
	
}
