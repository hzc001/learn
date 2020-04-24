package cn.it.shop.service;

import java.util.List;

/**
 * ��ɾ���ģ���ȡ��ҵ���ӿ�
 * @author Hzc
 *
 * @param <T>
 */
public interface BaseService<T> {
	public void save(T t);      // ����

	public void update(T t);    // �޸�
	
	public void delete(int id); // ɾ��
	
	public T get(int id);       // ��ȡһ��T
	
	public List<T> query();     // ��ȡȫ����T

}
