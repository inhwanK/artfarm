package org.hustar.artfarm.dto.notice;

import java.text.SimpleDateFormat;
import java.util.Date;

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

//	문자열로 프론트에 전달.
	private String registDate;
	private String updateDate;

	public NoticeResponseDto(Notice entity) {
		this.noticeIdx = entity.getNoticeIdx();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.writer = entity.getWriter();
		this.views = entity.getViews();
		this.registDate = parseDatetoString(entity.getRegistDate());
		this.updateDate = parseDatetoString(entity.getUpdateDate());
	}

//	날짜 포맷 변경 수정 필요.
	private String parseDatetoString(Date date) {

		SimpleDateFormat sDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		if (date != null) {
			return sDate.format(date);
		}else {
			return null;
		}

		
	}
}
