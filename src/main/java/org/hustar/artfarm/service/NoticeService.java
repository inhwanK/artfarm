package org.hustar.artfarm.service;

import javax.transaction.Transactional;

import org.hustar.artfarm.domain.notice.Notice;
import org.hustar.artfarm.domain.notice.NoticeRepository;
import org.hustar.artfarm.dto.notice.NoticeResponseDto;
import org.hustar.artfarm.dto.notice.NoticeSaveRequestDto;
import org.hustar.artfarm.dto.notice.NoticeUpdateRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeService {
	
	private final NoticeRepository noticeRepository;

	@Transactional
	public Page<NoticeResponseDto> getNoticeList(Pageable pageable) {
		Page<NoticeResponseDto> noticeList = 
				noticeRepository.findAllByOrderByNoticeIdxDesc(pageable).map(entity -> new NoticeResponseDto(entity));
		return noticeList;
	}

	@Transactional
	public NoticeResponseDto getNotice(Long noticeIdx) {
		Notice entity = noticeRepository.findById(noticeIdx)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + noticeIdx));
		
		entity.increaseViews();
		
		return new NoticeResponseDto(entity);
	}

	@Transactional
	public Long registerNotice(NoticeSaveRequestDto dto) {
		return noticeRepository.save(dto.toEntity()).getNoticeIdx();
	}

	@Transactional
	public Long updateNotice(Long noticeIdx, NoticeUpdateRequestDto requestDto) {
		Notice notice = noticeRepository.findById(noticeIdx)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + noticeIdx));
				
		notice.update(requestDto.getTitle(), requestDto.getContent());
		return noticeIdx;
	}

	@Transactional
	public Long deleteNotice(Long noticeIdx) {
		noticeRepository.deleteById(noticeIdx);
		return noticeIdx;
	}

	
}
