package org.hustar.artfarm.controller;

import org.hustar.artfarm.dto.notice.NoticeResponseDto;
import org.hustar.artfarm.dto.notice.NoticeSaveRequestDto;
import org.hustar.artfarm.service.NoticeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class RestNoticeController {

	private final NoticeService noticeService;
	
//	공지사항 목록 뽑기
	@GetMapping("/noticelist")
	public Page<NoticeResponseDto> getNoticeList(Pageable pageable){
		
		return noticeService.getNoticeList(pageable);
	}
	
//	공지사항 세부
//	/api/notice?noticeIdx=1
	@GetMapping("/notice")
	public NoticeResponseDto getNotice(Long noticeIdx) {
		return noticeService.getNotice(noticeIdx);
	}
	
//	공지사항 등록
	@PutMapping("/notice")
	public Long registerNotice(NoticeSaveRequestDto dto) {
		return noticeService.registNotice(dto);
	}
	
//	공지사항 수정
//	patch 
//	/api/notice?noticeIdx=1
	
//	공지사항 삭제
	@DeleteMapping("/notice/{noticeIdx}")
	public Long deleteNotice(Long noticeIdx) {
		return noticeService.deleteNotice(noticeIdx);
	}
}
