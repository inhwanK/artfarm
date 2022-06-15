package org.hustar.artfarm.service;

import java.io.IOException;
import java.util.List;

import org.hustar.artfarm.dto.file.ExhibitionFileResponseDto;
import org.springframework.web.multipart.MultipartFile;

public interface ExhibitionFileService {

	ExhibitionFileResponseDto getFile(Long fileIdx);
	
	List<ExhibitionFileResponseDto> getFileByExhibition(Long exhibitionIdx);
	
	Long uploadFileAndInfo(MultipartFile multipartFile, Long exhibitionIdx, String dirName) throws IOException;
}
