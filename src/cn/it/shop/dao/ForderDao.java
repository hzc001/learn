package cn.it.shop.dao;

import cn.it.shop.model.Forder;

/**
 * ������DAO�ӿ�
 * @author Hzc
 *
 */
public interface ForderDao extends BaseDao<Forder> {
	// ���ݶ�����ţ����¶���״̬
	public void updateStatusById(int id, int sid);
}
