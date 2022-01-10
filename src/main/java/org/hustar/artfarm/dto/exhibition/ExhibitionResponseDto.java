package org.hustar.artfarm.dto.exhibition;

import groovy.transform.builder.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExhibitionResponseDto {
	
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
	public ExhibitionResponseDto(Long exhibitionIdx, String title, String subTitle, String discription, String author,
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
	
	
}
