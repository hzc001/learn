package cn.it.shop.dao;

import java.util.List;

/**
 * ��ɾ���ģ���ȡ��DAO�ӿ�
 * @author Hzc
 *
 * @param <T>
 */
public interface BaseDao<T> {
	public void save(T t);      // ����

	public void update(T t);    // �޸�
	
	public void delete(int id); // ɾ��
	
	public T get(int id);       // ��ȡһ��T
	
	public List<T> query();     // ��ȡȫ����T

}
