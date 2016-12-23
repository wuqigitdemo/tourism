package org.honor.tourism.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUpload {

	@Value("${custom.file.upload.path}")
	private String fileUploadPath;

	/**
	 * 文件上传
	 * Controller方法参数例子：@RequestParam("uploadFile") MultipartFile file
	 * 页面form参数加  enctype="multipart/form-data"
	 * @param file
	 * @return
	 */
	public boolean uploadFile(MultipartFile file) {
		if (file.isEmpty()) {
			return false;
		}
		// 获取文件名
		String fileName = file.getOriginalFilename();
		String fileHeadName = fileName.substring(0, fileName.lastIndexOf("."));
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		StringBuffer sb = new StringBuffer();
		sb.append(fileUploadPath);
		sb.append(fileHeadName);
		sb.append(UUID.randomUUID());
		sb.append(suffixName);
		File dest = new File(sb.toString());
		// 检测是否存在目录
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			file.transferTo(dest);
			return true;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}
	
}
