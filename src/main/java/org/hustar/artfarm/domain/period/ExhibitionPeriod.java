package org.hustar.artfarm.domain.period;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hustar.artfarm.domain.exhibition.Exhibition;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "exhibition_period")
public class ExhibitionPeriod {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long periodIdx;
	
	
//	join 무한 루프 좀 더 제대로 공부할 필요 있음.
//	@JsonIgnoreProperties("exhibition") 
	@JsonBackReference
	@ManyToOne @JoinColumn(name = "exhibition_idx")
	private Exhibition exhibition;
	
	private LocalDate date;
	
//	private Time
	private Time startTime;
	private Time endTime;
	
	@Builder
	public ExhibitionPeriod(Long periodIdx, Exhibition exhibition, LocalDate date, Time startTime, Time endTime) {
		super();
		this.periodIdx = periodIdx;
		this.exhibition= exhibition;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public void update(LocalDate date, Time startTime,Time endTime) {
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}
}
