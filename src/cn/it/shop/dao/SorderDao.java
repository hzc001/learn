package cn.it.shop.dao;

import java.util.List;

import cn.it.shop.model.Sorder;

/**
 * �������DAO�ӿ�
 * @author Hzc
 *
 */
public interface SorderDao extends BaseDao<Sorder> {
	// ��ѯ�ȵ���Ʒ��������
	public List<Object> querySale(int number);
}
