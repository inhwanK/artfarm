package org.hustar.artfarm.controller;

import java.io.IOException;

import org.hustar.artfarm.domain.file.S3Uploader;
import org.hustar.artfarm.service.ExhibitionFileService;
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

	private final S3Uploader s3Uploader;
	private final ExhibitionFileService exhibitionFileService;

//	img path 불러오는 get 통신 해야함.

//	/images/files/{exhibition_idx}
	@PostMapping("/exhibition/files/{exhibitionIdx}")
	public Long upload(@RequestParam("files") MultipartFile multipartFile,
			@PathVariable("exhibitionIdx") Long exhibitionIdx) throws IOException {

		return exhibitionFileService.uploadFileAndInfo(multipartFile, exhibitionIdx, "exhibition");
	}

//	/exhibition/thumbnail
//	exhibitionFileService.uploadFileAndInfo(multipartFile, exhibitionIdx, "exhibition/");
}
