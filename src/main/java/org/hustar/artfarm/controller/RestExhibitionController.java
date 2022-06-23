package org.hustar.artfarm.controller;

import java.time.LocalDate;

import io.swagger.annotations.Api;
import org.hustar.artfarm.domain.exhibition.Category;
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

@Api(tags ="전시회 정보 처리 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class RestExhibitionController {

	private final ExhibitionService exhibitionService;

//	전시회 목록 뽑기, 페이징 처리 되어 있음.
	@GetMapping("/exhibitionlist")
	public Page<ExhibitionResponseDto> getExhibitionList(@PageableDefault(size = 15) Pageable pageable) {
		return exhibitionService.getExhibitionList(pageable);
	}

//	전시회 하나 가져오기, 기간도 함께
	@GetMapping("/exhibition")
	public ExhibitionResponseDto getExhibition(Long exhibitionIdx) {
		return exhibitionService.getExhibition(exhibitionIdx);
	}

//	진행 중인 전시회 검색, 예시) /api/exhibition/period?date=2022-01-22
	@GetMapping("/exhibition/period")
	public Page<ExhibitionResponseDto> getExhibitionListByPeriod(
			@RequestParam("date") @DateTimeFormat(iso = ISO.DATE) LocalDate date,
			@PageableDefault(size = 15) Pageable pageable) {

		return exhibitionService.getExhibitionListByDate(date, pageable);
	}

//	카테고리 별 전시회 검색, 예시) /api/exhibition/category?category=2022-01-22
	@GetMapping("/exhibition/category")
	public Page<ExhibitionResponseDto> getExhibitionListByCategory(Category category,Pageable pageable) {

		return exhibitionService.getExhibitionListByCategory(category, pageable);
	}

//	전시회 등록.
	@PostMapping("/exhibition")
	public Long registerExhibition(@RequestBody ExhibitionSaveUpdateRequestDto dto) {
		return exhibitionService.registerExhibition(dto);
	}

//	전시회 수정.
	@PutMapping("/exhibition")
	public Long updateExhibition(Long exhibitionIdx, @RequestBody ExhibitionSaveUpdateRequestDto dto) {
		return exhibitionService.updateExhibition(exhibitionIdx, dto);
	}

//	전시회 삭제.
	@DeleteMapping("/exhibtion")
	public Long deleteExhbition(Long exhibitionIdx) {
		return exhibitionService.deleteExhibition(exhibitionIdx);
	}
}
