package org.hustar.artfarm.controller;

import org.hustar.artfarm.dto.exhibition.ExhibitionResponseDto;
import org.hustar.artfarm.service.ExhibitionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class RestExhibitionController {

	private final ExhibitionService exhibitionService;
	
//	전시회 목록 뽑기, 페이징 처리 되어 있음.
	@GetMapping("/exhibitionlist")
	public Page<ExhibitionResponseDto> getExhibitionList(Pageable pageable){
		return exhibitionService.getExhibitionList(pageable);
	}
	
	@GetMapping("/exhibition")
	public ExhibitionResponseDto getExhibition(Long exhibitionIdx){
		return exhibitionService.getExhibition(exhibitionIdx);
	}
}
