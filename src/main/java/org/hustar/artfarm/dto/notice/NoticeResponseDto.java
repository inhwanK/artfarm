package org.hustar.artfarm.dto.notice;


import java.util.Date;

import org.hustar.artfarm.domain.notice.Notice;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeResponseDto {
	
	private Long noticeIdx;
	private String title;
	private String content;
	private String writer;
	private Long views;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateDate;

	public NoticeResponseDto(Notice entity) {
		this.noticeIdx = entity.getNoticeIdx();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.writer = entity.getWriter();
		this.views = entity.getViews();
		this.registDate = entity.getRegistDate();
		this.updateDate = entity.getUpdateDate();
	}
	
	
}
