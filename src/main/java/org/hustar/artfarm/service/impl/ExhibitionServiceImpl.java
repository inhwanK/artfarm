package org.hustar.artfarm.service.impl;

import org.hustar.artfarm.domain.exhibition.Exhibition;
import org.hustar.artfarm.domain.exhibition.ExhibitionRepository;
import org.hustar.artfarm.domain.notice.Notice;
import org.hustar.artfarm.dto.exhibition.ExhibitionResponseDto;
import org.hustar.artfarm.dto.exhibition.ExhibitionSaveUpdateRequestDto;
import org.hustar.artfarm.service.ExhibitionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExhibitionServiceImpl implements ExhibitionService {

	private final ExhibitionRepository exhibitionRepository;
	
	@Override
	public Page<ExhibitionResponseDto> getExhibitionList(Pageable pageable) {
		Page<ExhibitionResponseDto> exhibitionList =
				exhibitionRepository.findAllByOrderByExhibitionIdxDesc(pageable).map(entity -> new ExhibitionResponseDto(entity));
		
		return exhibitionList;
	}

	@Override
	public ExhibitionResponseDto getExhibition(Long exhibitionIdx) {
		Exhibition entity = exhibitionRepository.findById(exhibitionIdx)
				.orElseThrow(() -> new IllegalArgumentException("해당 전시회 정보가 없습니다. id="+ exhibitionIdx));
		return new ExhibitionResponseDto(entity);
	}

	@Override
	public Long registerExhibition(ExhibitionSaveUpdateRequestDto dto) {
		
		return exhibitionRepository.save(dto.toEntity()).getExhibitionIdx();
	}

	@Override
	public Long updateExhibition(Long exhibitionIdx, ExhibitionSaveUpdateRequestDto dto) {
		Exhibition exhibition = exhibitionRepository.findById(exhibitionIdx)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + exhibitionIdx));
		
		exhibition.builder()
			.title(dto.getTitle())
			.subTitle(dto.getSubTitle())
			.discription(dto.getDiscription())
			.author(dto.getAuthor())
			.category(dto.getCategory())
			.place(dto.getPlace())
			.url(dto.getUrl())
			.onOff(dto.isOnOff())
			.thumbnail(dto.getThumbnail());
		return exhibitionIdx;
	}

	@Override
	public Long deleteExhibition(Long exhibitionIdx) {
		exhibitionRepository.deleteById(exhibitionIdx);
		return exhibitionIdx;
	}

}
