package org.hustar.artfarm.domain.period;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hustar.artfarm.domain.exhibition.Exhibition;

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
	
	@ManyToOne
	@JoinColumn(name = "exhibition_idx")
	private Exhibition exhibition;
	
	private Date date;
	private Timestamp startTime;
	private Timestamp endTime;
	
	@Builder
	public ExhibitionPeriod(Long periodIdx, Exhibition exhibition, Date date, Timestamp startTime, Timestamp endTime) {
		super();
		this.periodIdx = periodIdx;
		this.exhibition= exhibition;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public void update(Date date, Timestamp startTime,Timestamp endTime) {
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}
}
