package org.hustar.artfarm.dto.notice;

import java.time.format.DateTimeFormatter;

import org.hustar.artfarm.domain.notice.Notice;

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
	private String registDate;
	private String updateDate;

	public NoticeResponseDto(Notice entity) {
		this.noticeIdx = entity.getNoticeIdx();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.writer = entity.getWriter();
		this.views = entity.getViews();	
		this.registDate = entity.getRegistDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		this.updateDate = entity.getUpdateDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	}
}
