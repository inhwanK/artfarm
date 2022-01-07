package org.hustar.artfarm.dto.notice;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeUpdateRequestDto {

	private String title;
	private String content;
	private Date updateDate;

	@Builder
	public NoticeUpdateRequestDto(String title, String content, Date updateDate) {
		super();
		this.title = title;
		this.content = content;
		this.updateDate = updateDate;
	}
}
