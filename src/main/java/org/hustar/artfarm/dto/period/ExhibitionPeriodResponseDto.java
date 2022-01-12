package org.hustar.artfarm.dto.period;

import java.sql.Timestamp;
import java.util.Date;

import org.hustar.artfarm.domain.exhibition.Exhibition;
import org.hustar.artfarm.domain.period.ExhibitionPeriod;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExhibitionPeriodResponseDto {

	private Long periodIdx;
	private Exhibition exhibition;
	
	private Date date;
	private Timestamp startTime;
	private Timestamp endTime;
	
	/*
	public ExhibitionPeriodResponseDto(ExhibitionPeriod entity) {

		this.periodIdx = entity.getPeriodIdx();
		this.exhibition = exhibition;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}*/
	
	
}
