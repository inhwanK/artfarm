package org.hustar.artfarm.controller;

import java.io.IOException;

import org.hustar.artfarm.domain.file.S3Uploader;
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

	private final S3Uploader s3Uploader;
	private final ExhibitionFileService exhibitionFileService;

//	img 불러오는 get 통신 해야함.
	@GetMapping("/images")
	public String download(String fileName) {
		return "https://artfarm-storage.s3.ap-northeast-2.amazonaws.com/static/" + fileName;
	}

//	/images/{exhibition_idx}
	@PostMapping("/exhibition/files/{exhibitionIdx}")
	public String upload(@RequestParam("files") MultipartFile multipartFile, @PathVariable("exhibitionIdx") Long exhibitionIdx) throws IOException {
//		s3Uploader.upload(multipartFile, "exhibition");
		exhibitionFileService.uploadFileAndInfo(multipartFile, exhibitionIdx, "exhibition");
		return "test";
	}

//	/exhibition/thumbnail
//	exhibitionFileService.uploadFileAndInfo(multipartFile, exhibitionIdx, "exhibition/");
}
