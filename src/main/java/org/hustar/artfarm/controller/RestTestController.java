package org.hustar.artfarm.controller;

import org.hustar.artfarm.dto.TestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestTestController {
	
	@GetMapping("/test")
	public TestDto getTest() {
		TestDto dto = new TestDto();
		dto.setTestId((long) 1234);
		dto.setTestString("김인표 바보");
		return dto;
	}
	
}
