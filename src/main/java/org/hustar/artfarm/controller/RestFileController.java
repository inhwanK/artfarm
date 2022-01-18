package org.hustar.artfarm.controller;

import java.io.IOException;

import org.hustar.artfarm.file.S3Uploader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class RestFileController {

	private final S3Uploader s3Uploader;

//	img 불러오는 get 통신 해야함.
	@GetMapping("/getimage")
	public String download(String fileName) {
		return "https://artfarm-storage.s3.ap-northeast-2.amazonaws.com/static/" + fileName;
	}

	@PostMapping("/images")
	public String upload(@RequestParam("images") MultipartFile multipartFile) throws IOException {
		s3Uploader.upload(multipartFile, "static");
		return "test";
	}
}
