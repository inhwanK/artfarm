package org.hustar.artfarm.domain.notice;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "notice")
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long noticeIdx;

	private String title;
	private String content;
	private String writer;
	private Long views;
	private LocalDateTime registDate;
	private LocalDateTime updateDate;

	@Builder
	public Notice(Long noticeIdx, String title, String content, String writer, Long views, LocalDateTime registDate,
			LocalDateTime updateDate) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.views = views;
		this.registDate = registDate;
		this.updateDate = updateDate;
	}

	public void update(String title, String content, LocalDateTime updateDate) {
		this.title = title;
		this.content = content;
		this.updateDate = updateDate;
	}
}
