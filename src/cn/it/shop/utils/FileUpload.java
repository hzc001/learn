package cn.it.shop.utils;

import cn.it.shop.model.FileImage;

/**
 * ʵ���ļ��ϴ��Ĺ�����ӿ�
 * @author Hzc
 *
 */
public interface FileUpload {

	// ʵ���ļ��ϴ��Ĺ��ܣ������ϴ����µ��ļ�����
	public abstract String uploadFile(FileImage fileImage);

	// ������е�ͼ��
	public String[] getBankImage();
}