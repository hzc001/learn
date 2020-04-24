package cn.it.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.it.shop.dao.CategoryDao;
import cn.it.shop.model.Category;

/**
 * ��Ʒ����DAOʵ����
 * @author Hzc
 *
 */
@SuppressWarnings("unchecked")
@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

	@Override
	// ��ѯ�����Ϣ����������Ա
	public List<Category> queryJoinAccount(String type, int page, int size) {
		// left join��ʾ����Accountһ���ѯ��fetch��ʾ��Account����ӵ�Category�У�fetch�൱���ڳ�����������lazy=false
		String hql = "from Category c left join fetch c.account where c.type like :type";
		List<Category> list = getSession().createQuery(hql).setString("type", "%" + type + "%")
				.setFirstResult((page - 1) * size) // �ӵڼ�����ʼ��ʾ
				.setMaxResults(size) // ��ʾ����
				.list();
		return list;
	}

	@Override
	// ���ݹؼ��ֲ�ѯ�ܼ�¼��
	public Long getCount(String type) {
		String hql = "select count(c) from Category c where c.type like :type";
		Long num = (Long) getSession().createQuery(hql).setString("type", "%" + type + "%").uniqueResult(); // ֻ����һ����¼:�ܼ�¼��
		return num;
	}

	@Override
	// ����idsɾ��������¼
	public void deleteByIds(String ids) {
		String hql = "delete from Category c where c.id in (" + ids + ")";
		getSession().createQuery(hql).executeUpdate();
	}

	@Override
	// ����boelenֵ��ѯ�ȵ����ȵ����
	public List<Category> queryByHot(boolean hot) {
		String hql = "from Category c where c.hot=:hot";
		List<Category> list = getSession().createQuery(hql).setBoolean("hot", hot).list();
		return list;
	}
}
