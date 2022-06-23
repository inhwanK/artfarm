package org.hustar.artfarm.dto.notice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "NoticeUpdateRequestDto : 공지사항 수정 요청 Dto", description = "공지사항 수정 요청 Dto")
@Getter
@Setter
@NoArgsConstructor
public class NoticeUpdateRequestDto {

	@ApiModelProperty(value = "수정할 공지사항 제목", required = false, example = "수정된 공지사항 제목")
	private String title;
	@ApiModelProperty(value = "수정할 공지사항 내용", required = false, example = "수정된 공지사항 내용")
	private String content;

	@Builder
	public NoticeUpdateRequestDto(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
}
