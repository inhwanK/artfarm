package org.hustar.artfarm.controller;

import java.time.LocalDate;

import org.hustar.artfarm.dto.exhibition.ExhibitionResponseDto;
import org.hustar.artfarm.dto.exhibition.ExhibitionSaveUpdateRequestDto;
import org.hustar.artfarm.service.ExhibitionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class RestExhibitionController {

	private final ExhibitionService exhibitionService;
//	private final ExhibitionPeriodService exhibitionPeriodService;

//	전시회 목록 뽑기, 페이징 처리 되어 있음.
	@GetMapping("/exhibitionlist")
	public Page<ExhibitionResponseDto> getExhibitionList(@PageableDefault(size = 15) Pageable pageable) {
		return exhibitionService.getExhibitionList(pageable);
	}

	@GetMapping("/exhibition")
	public ExhibitionResponseDto getExhibition(Long exhibitionIdx) {
		return exhibitionService.getExhibition(exhibitionIdx);
	}

	@GetMapping("/exhibition/period")
	public Page<ExhibitionResponseDto> getExhibitionListByPeriod(
			@RequestParam("date") @DateTimeFormat(iso = ISO.DATE) LocalDate date,
			@PageableDefault(size = 15) Pageable pageable) {

		return exhibitionService.getExhibitionListByDate(date, pageable);
	}
	
	@GetMapping("/exhibition/category")
	public Page<ExhibitionResponseDto> getExhibitionListByCategory(String category,Pageable pageable) {

		
		return exhibitionService.getExhibitionListByCategory(category, pageable);
	}

	@PostMapping("/exhibition")
	public Long registerExhibition(@RequestBody ExhibitionSaveUpdateRequestDto dto) {
		return exhibitionService.registerExhibition(dto);
	}

	@PutMapping("/exhibition")
	public Long updateExhibition(Long exhibitionIdx, @RequestBody ExhibitionSaveUpdateRequestDto dto) {
		return exhibitionService.updateExhibition(exhibitionIdx, dto);
	}

	@DeleteMapping("/exhibtion")
	public Long deleteExhbition(Long exhibitionIdx) {
		return exhibitionService.deleteExhibition(exhibitionIdx);
	}
}
