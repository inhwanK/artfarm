package org.hustar.artfarm.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface ExhibitionFileService {

	public Long uploadFileAndInfo(MultipartFile multipartFile, Long exhibitionIdx, String dirName) throws IOException;
}
