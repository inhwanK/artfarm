package org.hustar.artfarm.dto.notice;

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

	@Builder
	public NoticeSaveRequestDto(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public Notice toEntity() {
		return Notice.builder()
				.title(title)
				.content(content)
				.writer(writer)
				.build();
	}
}
