package org.hustar.artfarm.domain.notice;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
 
@Getter
@NoArgsConstructor
@Entity
@Table(name="notice")
public class Notice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long noticeId;
	
	private String title;
	private String content;
	private String writer;
	private Long views;
	private Date registDate;
	private Date updateDate;

	@Builder
	public Notice(Long noticeId, String title, String content, String writer, Long views, Date registDate,
			Date updateDate) {
		super();
		this.noticeId = noticeId;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.views = views;
		this.registDate = registDate;
		this.updateDate = updateDate;
	}

}
