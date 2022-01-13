package org.hustar.artfarm.dto.notice;

import java.time.LocalDateTime;

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
	
//	update 날짜 갱신.
	private LocalDateTime updateDate;

	@Builder
	public NoticeUpdateRequestDto(String title, String content, LocalDateTime updateDate) {
		super();
		this.title = title;
		this.content = content;
		this.updateDate = updateDate;
	}
}
