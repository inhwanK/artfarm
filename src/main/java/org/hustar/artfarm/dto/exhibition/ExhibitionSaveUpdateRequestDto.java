package org.hustar.artfarm.dto.exhibition;

import java.util.ArrayList;
import java.util.List;

import org.hustar.artfarm.domain.exhibition.Category;
import org.hustar.artfarm.domain.exhibition.Exhibition;
import org.hustar.artfarm.dto.period.ExhibitionPeriodSaveRequestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExhibitionSaveUpdateRequestDto {

	private String title;
	private String subTitle;
	private String discription;
	private String author;
	private Category category;
	private String place;
	private String url;
	private boolean onOff;
	private String thumbnail;
	
//	전시회 기간 배열 형태로 파라미터 전달해야함.
	private List<ExhibitionPeriodSaveRequestDto> exhPeriod = new ArrayList<ExhibitionPeriodSaveRequestDto>();
	
	public ExhibitionSaveUpdateRequestDto(String title, String subTitle, String discription, String author, Category category,
			String place, String url, boolean onOff, String thumbnail, List<ExhibitionPeriodSaveRequestDto> exhPeriod) {
		super();
		this.title = title;
		this.subTitle = subTitle;
		this.discription = discription;
		this.author = author;
		
		if(category != null) {
			this.category = category;
		}else {
			this.category = Category.NONE;
		}
		
		this.place = place;
		this.url = url;
		this.onOff = onOff;
		this.thumbnail = thumbnail;
		exhPeriod.forEach(dto -> this.exhPeriod.add(dto));
	}
	
	public Exhibition toEntity() {
		return Exhibition.builder()
				.title(title)
				.subTitle(subTitle)
				.discription(discription)
				.author(author)
				.category(category)
				.place(place)
				.url(url)
				.onOff(onOff)
				.thumbnail(thumbnail)
				.exhPeriod(exhPeriod)
				.build();
	}
}
