package org.hustar.artfarm.controller;

import java.util.List;

import org.hustar.artfarm.domain.exhibition.Exhibition;
import org.hustar.artfarm.service.ExhibitionPeriodService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class RestExhibitionPeriodController {

	private final ExhibitionPeriodService exhibitionPeriodService;
	
	@GetMapping("/period")
	public String getPeriod(){

		exhibitionPeriodService.getPeriod();
		
		return "되었느냐?";
	}
}