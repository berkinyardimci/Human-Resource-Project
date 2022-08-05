package com.hrms.core.utilities.pictureService;

import com.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;


public interface PictureService {
	DataResult<?> save(MultipartFile file);
}
