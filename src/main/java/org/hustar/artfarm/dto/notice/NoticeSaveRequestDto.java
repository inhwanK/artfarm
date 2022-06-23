package org.hustar.artfarm.dto.notice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hustar.artfarm.domain.notice.Notice;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "NoticeSaveRequestDto : 공지사항 등록 요청 Dto", description = "공지사항 등록 요청 Dto")
@Getter
@Setter
@NoArgsConstructor
public class NoticeSaveRequestDto {

	@ApiModelProperty(value = "등록할 공지사항 제목", required = true, example = "제목입니다.")
	private String title;
	@ApiModelProperty(value = "등록할 공지사항 내용", required = true, example = "내용은 이런겁니다 알겠습니까")
	private String content;
	@ApiModelProperty(value = "등록할 공지사항 작성자", required = true, example = "김인환")
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
