package org.hustar.artfarm.service.impl;

import java.io.IOException;

import javax.transaction.Transactional;

import org.hustar.artfarm.domain.file.ExhibitionFileRepository;
import org.hustar.artfarm.domain.file.S3Uploader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExhibitionFileService implements org.hustar.artfarm.service.ExhibitionFileService {

	private final S3Uploader s3Uploader;
	private final ExhibitionFileRepository fileRepository;

	@Transactional
	@Override
	public Long uploadFileAndInfo(MultipartFile multipartFile, Long exhibitionIdx, String dirName) throws IOException {

		// dirName 지정

		String fileUrl = s3Uploader.upload(multipartFile, exhibitionIdx, dirName);
		String[] url = fileUrl.split("/");

		String fileName = url[url.length - 1];
		System.out.println("service에서 fileName 뽑아오기 > " + fileName);
		System.out.println("service에서 fileName 뽑아오기 2 > " + multipartFile.getOriginalFilename());

		return null;
	}

}
