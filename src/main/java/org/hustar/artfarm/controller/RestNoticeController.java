package org.hustar.artfarm.controller;

import org.hustar.artfarm.dto.notice.NoticeResponseDto;
import org.hustar.artfarm.dto.notice.NoticeSaveRequestDto;
import org.hustar.artfarm.dto.notice.NoticeUpdateRequestDto;
import org.hustar.artfarm.service.NoticeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class RestNoticeController {

	private final NoticeService noticeService;

//	공지사항 목록 뽑기, 페이징 처리 되어 있음. 
	@GetMapping("/noticelist")
	public Page<NoticeResponseDto> getNoticeList(@PageableDefault(size = 10) Pageable pageable) {
		return noticeService.getNoticeList(pageable);
	}

//	공지사항 세부
//	/api/notice?noticeIdx=1 
	@GetMapping("/notice")
	public NoticeResponseDto getNotice(Long noticeIdx) {
		return noticeService.getNotice(noticeIdx);
	}

//	공지사항 등록
	@PostMapping("/notice")
	public Long registerNotice(@RequestBody NoticeSaveRequestDto dto) {
		return noticeService.registerNotice(dto);
	}

//	공지사항 수정
	@PutMapping("/notice")
	public Long updateNotice(Long noticeIdx, @RequestBody NoticeUpdateRequestDto dto) {

		return noticeService.updateNotice(noticeIdx, dto);
	}

//	공지사항 삭제
	@DeleteMapping("/notice")
	public Long deleteNotice(Long noticeIdx) {
		return noticeService.deleteNotice(noticeIdx);
	}
}
