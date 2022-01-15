package org.hustar.artfarm.dto.period;

import java.sql.Time;
import java.time.LocalDate;

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

	private LocalDate date;
	private Time startTime;
	private Time endTime;

	public ExhibitionPeriodResponseDto(ExhibitionPeriod entity) {

		this.periodIdx = entity.getPeriodIdx();
		this.exhibition = entity.getExhibition();
		this.date = entity.getDate();
		this.startTime = entity.getStartTime();
		this.endTime = entity.getEndTime();
	}

}
