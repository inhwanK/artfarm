package org.hustar.artfarm.dto.exhibition;

import org.hustar.artfarm.domain.exhibition.Exhibition;

import lombok.Builder;
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
	private String category;
	private String place;
	private String url;
	private boolean onOff;
	private String thumbnail;
	
	@Builder
	public ExhibitionSaveUpdateRequestDto(String title, String subTitle, String discription, String author, String category,
			String place, String url, boolean onOff, String thumbnail) {
		super();
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
				.build();
	}
}
