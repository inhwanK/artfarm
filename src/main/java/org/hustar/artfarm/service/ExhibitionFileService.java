package org.hustar.artfarm.service;

import java.io.IOException;
import java.util.List;

import org.hustar.artfarm.dto.file.ExhibitionFileResponseDto;
import org.springframework.web.multipart.MultipartFile;

public interface ExhibitionFileService {

	public ExhibitionFileResponseDto getFile(Long fileIdx);
	
	public List<ExhibitionFileResponseDto> getFileByExhibition(Long exhibitionIdx);
	
	public Long uploadFileAndInfo(MultipartFile multipartFile, Long exhibitionIdx, String dirName) throws IOException;
}
