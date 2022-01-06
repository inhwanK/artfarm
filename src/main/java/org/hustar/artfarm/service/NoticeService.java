package org.hustar.artfarm.service;

import org.hustar.artfarm.dto.notice.NoticeResponseDto;
import org.hustar.artfarm.dto.notice.NoticeSaveRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface NoticeService {

//	공지 목록 조회
	public Page<NoticeResponseDto> getNoticeList(Pageable pageable);

//	공지 목록 조회
	public NoticeResponseDto getNotice(Long noticeIdx);

//	공지 등록
	public Long registNotice(NoticeSaveRequestDto dto);
	
//	공지 수정
	public Long updateNotice();
	
//	공지 삭제
	public Long deleteNotice(Long noticeIdx);
}
