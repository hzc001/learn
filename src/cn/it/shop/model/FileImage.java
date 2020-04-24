package cn.it.shop.model;

import java.io.File;

/**
 * ͼƬ�ļ���ʵ��
 * @author Hzc
 *
 */
public class FileImage {
	private File file;
	private String contentType;
	private String fileName;
	
	public File getFile() {
		return file;
	}

	public String getContentType() {
		return contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setUpload(File file) {
		this.file = file;
	}
	
	public void setUploadContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public void setUploadFileName(String fileName) {
		this.fileName = fileName;
	}
}
