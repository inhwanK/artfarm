package org.hustar.artfarm.dto.period;

import java.sql.Timestamp;
import java.time.LocalDate;

import org.hustar.artfarm.domain.exhibition.Exhibition;
import org.hustar.artfarm.domain.period.ExhibitionPeriod;

import groovy.transform.builder.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExhibitionPeriodSaveRequestDto {
	
	private Exhibition exhibition;
	
//	private Long exhibitionIdx;
	private LocalDate date;
	private Timestamp startTime;
	private Timestamp endTime;
	
	@Builder
	public ExhibitionPeriodSaveRequestDto(Exhibition exhibition,Long exhibitionIdx, LocalDate date, Timestamp startTime,
			Timestamp endTime) {
		super();
		this.exhibition = exhibition;
//		this.exhibitionIdx = exhibitionIdx;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public ExhibitionPeriod toEntity() {
		return ExhibitionPeriod.builder()
				.exhibition(exhibition)
				.date(date)
				.startTime(startTime)
				.endTime(endTime)
				.build();
	}
	
}
