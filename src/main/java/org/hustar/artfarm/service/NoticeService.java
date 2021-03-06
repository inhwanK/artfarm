package org.hustar.artfarm.service;

import org.hustar.artfarm.dto.notice.NoticeResponseDto;
import org.hustar.artfarm.dto.notice.NoticeSaveRequestDto;
import org.hustar.artfarm.dto.notice.NoticeUpdateRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface NoticeService {

//	공지 목록 조회
	Page<NoticeResponseDto> getNoticeList(Pageable pageable);

//	공지 목록 조회
	NoticeResponseDto getNotice(Long noticeIdx);

//	공지 등록
	Long registerNotice(NoticeSaveRequestDto dto);
	
//	공지 수정
	Long updateNotice(Long noticeIdx, NoticeUpdateRequestDto requestDto);
	
//	공지 삭제
	Long deleteNotice(Long noticeIdx);

}
