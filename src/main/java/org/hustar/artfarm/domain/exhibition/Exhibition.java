package org.hustar.artfarm.domain.exhibition;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hustar.artfarm.domain.period.ExhibitionPeriod;
import org.hustar.artfarm.dto.period.ExhibitionPeriodSaveRequestDto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "exhibition")
public class Exhibition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long exhibitionIdx;
	
	private String title;
	private String subTitle;
	private String discription;
	private String author;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	private String place;
	private String url;
	private boolean onOff;
	
//	수정 가능성 많음
	private String thumbnail;
	
//	조인 무한루프 좀 더 공부해야함.
//	@JsonIgnoreProperties("exhibition")
	@OneToMany(mappedBy = "exhibition") @JsonManagedReference
	private List<ExhibitionPeriod> exhPeriod = new ArrayList<ExhibitionPeriod>();

	@Builder
	public Exhibition(Long exhibitionIdx, String title, String subTitle, String discription, String author,
			Category category, String place, String url, boolean onOff, String thumbnail, List<ExhibitionPeriodSaveRequestDto> exhPeriod) {
		this.title = title;
		this.subTitle = subTitle;
		this.discription = discription;
		this.author = author;
		this.category = category;
		this.place = place;
		this.url = url;
		this.onOff = onOff;
		this.thumbnail = thumbnail;
		exhPeriod.forEach(dto -> this.exhPeriod.add(dto.toEntity()));
	}

	public void update(String title, String subTitle, String discription, String author,
			Category category, String place, String url, boolean onOff, String thumbnail, List<ExhibitionPeriodSaveRequestDto> exhPeriod) {
		this.title = title;
		this.subTitle = subTitle;
		this.discription = discription;
		this.author = author;
		this.category = category;
		this.place = place;
		this.url = url;
		this.onOff = onOff;
		this.thumbnail = thumbnail;
		exhPeriod.forEach(dto -> this.exhPeriod.add(dto.toEntity()));
	}

}

