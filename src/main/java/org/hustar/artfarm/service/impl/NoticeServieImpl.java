package org.hustar.artfarm.service.impl;

import javax.transaction.Transactional;

import org.hustar.artfarm.domain.notice.Notice;
import org.hustar.artfarm.domain.notice.NoticeRepository;
import org.hustar.artfarm.dto.notice.NoticeResponseDto;
import org.hustar.artfarm.dto.notice.NoticeSaveRequestDto;
import org.hustar.artfarm.dto.notice.NoticeUpdateRequestDto;
import org.hustar.artfarm.service.NoticeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeServieImpl implements NoticeService {
	
	private final NoticeRepository noticeRepository;

	@Transactional
	@Override
	public Page<NoticeResponseDto> getNoticeList(Pageable pageable) {
		Page<NoticeResponseDto> noticeList =
				noticeRepository.findAllByOrderByNoticeIdxDesc(pageable).map(entity -> new NoticeResponseDto(entity));
		return noticeList;
	}

	@Transactional
	@Override
	public NoticeResponseDto getNotice(Long noticeIdx) {
		Notice entity = noticeRepository.findById(noticeIdx)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + noticeIdx));
		
		return new NoticeResponseDto(entity);
	}

	@Transactional
	@Override
	public Long registNotice(NoticeSaveRequestDto dto) {
		return noticeRepository.save(dto.toEntity()).getNoticeIdx();
	}

	@Transactional
	@Override
	public Long updateNotice(Long noticeIdx, NoticeUpdateRequestDto requestDto) {
		Notice notice = noticeRepository.findById(noticeIdx)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + noticeIdx));;
				
		notice.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getUpdateDate());
		return noticeIdx;
	}

	@Transactional
	@Override
	public Long deleteNotice(Long noticeIdx) {
		noticeRepository.deleteById(noticeIdx);
		return noticeIdx;
	}

}
