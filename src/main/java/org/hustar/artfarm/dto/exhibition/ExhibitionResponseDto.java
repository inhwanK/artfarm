package org.hustar.artfarm.dto.exhibition;

import java.util.ArrayList;
import java.util.List;

import org.hustar.artfarm.domain.exhibition.Exhibition;
import org.hustar.artfarm.domain.file.ExhibitionFile;
import org.hustar.artfarm.domain.period.ExhibitionPeriod;

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
	
	private List<ExhibitionFile> exhFile = new ArrayList<ExhibitionFile>();
	
	private List<ExhibitionPeriod> exhPeriod = new ArrayList<ExhibitionPeriod>();

	public ExhibitionResponseDto(Exhibition entity) {
		super();
		this.exhibitionIdx = entity.getExhibitionIdx();
		this.title = entity.getTitle();
		this.subTitle = entity.getSubTitle();
		this.discription = entity.getDiscription();
		this.author = entity.getAuthor();
		this.category = entity.getCategory().getCategory();
		this.place = entity.getPlace();
		this.url = entity.getUrl();
		this.onOff = entity.isOnOff();
		this.thumbnail = entity.getThumbnail();
		entity.getExhFile().forEach(file ->this.exhFile.add(file));
		entity.getExhPeriod().forEach(i -> this.exhPeriod.add(i));
	}
	
	
}
