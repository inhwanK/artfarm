package org.hustar.artfarm.dto.exhibition;

import org.hustar.artfarm.domain.exhibition.Exhibition;

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

	public ExhibitionResponseDto(Exhibition entity) {
		super();
		this.exhibitionIdx = entity.getExhibitionIdx();
		this.title = entity.getTitle();
		this.subTitle = entity.getSubTitle();
		this.discription = entity.getDiscription();
		this.author = entity.getAuthor();
		this.category = entity.getCategory();
		this.place = entity.getPlace();
		this.url = entity.getUrl();
		this.onOff = entity.isOnOff();
		this.thumbnail = entity.getThumbnail();
	}
	
	
}
