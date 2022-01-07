package org.hustar.artfarm.dto.notice;

import java.util.Date;

import org.hustar.artfarm.domain.notice.Notice;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeSaveRequestDto {

	private String title;
	private String content;
	private String writer;
	private Date registDate;

	@Builder
	public NoticeSaveRequestDto(String title, String content, String writer, Date registDate) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.registDate = registDate;
	}

	public Notice toEntity() {
		return Notice.builder().title(title).content(content).writer(writer).registDate(registDate).build();
	}
}
