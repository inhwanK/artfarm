package org.hustar.artfarm.controller;

import java.io.IOException;
import java.util.List;

import org.hustar.artfarm.dto.file.ExhibitionFileResponseDto;
import org.hustar.artfarm.service.ExhibitionFileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class RestFileController {

	private final ExhibitionFileService exhibitionFileService;

//	filesIdx로 img path 불러오는 get (실제로 안씀)
	@GetMapping("/exhibition/files")
	public ExhibitionFileResponseDto getFile(@RequestParam("fileIdx") Long fileIdx) {

		return exhibitionFileService.getFile(fileIdx);
	}

//	전시회 Idx로 img path 불러오는 get (이걸 주로 씀)
	@GetMapping("/exhibition/files/{exhibitionIdx}")
	public List<ExhibitionFileResponseDto> getFileByExhibitionIdx(@PathVariable Long exhibitionIdx) {

		return exhibitionFileService.getFileByExhibition(exhibitionIdx);
	}

//	전시회 파일 저장과 동시에 path도 DB에 저장하는 post 요청.
//	/images/files/{exhibition_idx}
	@PostMapping("/exhibition/files/{exhibitionIdx}")
	public Long upload(@RequestParam("files") MultipartFile multipartFile,
			@PathVariable("exhibitionIdx") Long exhibitionIdx) throws IOException {

		return exhibitionFileService.uploadFileAndInfo(multipartFile, exhibitionIdx, "exhibition");
	}

//	/exhibition/thumbnail
//	exhibitionFileService.uploadFileAndInfo(multipartFile, exhibitionIdx, "exhibition/");
}
