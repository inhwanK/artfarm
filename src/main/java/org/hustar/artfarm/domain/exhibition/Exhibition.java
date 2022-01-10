package org.hustar.artfarm.domain.exhibition;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String category;
	private String place;
	private String url;
	private boolean onOff;
	
//	수정 가능성 많음
	private String thumbnail;

	@Builder
	public Exhibition(Long exhibitionIdx, String title, String subTitle, String discription, String author,
			String category, String place, String url, boolean onOff, String thumbnail) {
		super();
		this.exhibitionIdx = exhibitionIdx;
		this.title = title;
		this.subTitle = subTitle;
		this.discription = discription;
		this.author = author;
		this.category = category;
		this.place = place;
		this.url = url;
		this.onOff = onOff;
		this.thumbnail = thumbnail;
	}

	public void update(Long exhibitionIdx, String title, String subTitle, String discription, String author,
			String category, String place, String url, boolean onOff, String thumbnail) {
		this.exhibitionIdx = exhibitionIdx;
		this.title = title;
		this.subTitle = subTitle;
		this.discription = discription;
		this.author = author;
		this.category = category;
		this.place = place;
		this.url = url;
		this.onOff = onOff;
		this.thumbnail = thumbnail;
	}



	
}

