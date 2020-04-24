package cn.it.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.it.shop.dao.ProductDao;

import cn.it.shop.model.Product;

/**
 * ��Ʒ��DAOʵ����
 * @author Hzc
 *
 */
@SuppressWarnings("unchecked")
@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

	@Override
	// ��ѯ��Ʒ��Ϣ���������
	public List<Product> queryJoinCategory(String name, int page, int size) {
		String hql = "from Product p left join fetch p.category where p.name like :name";
		List<Product> list = getSession().createQuery(hql).setString("name", "%" + name + "%")
				.setFirstResult((page - 1) * size) // �ӵڼ�����ʼ��ʾ
				.setMaxResults(size) // ��ʾ����
				.list();
		return list;
	}

	@Override
	// ���ݹؼ��ֲ�ѯ�ܼ�¼��
	public Long getCount(String name) {
		String hql = "select count(p) from Product p where p.name like :name";
		Long num = (Long) getSession().createQuery(hql).setString("name", "%" + name + "%").uniqueResult(); // ֻ����һ����¼:�ܼ�¼��
		return num;
	}

	@Override
	// ����idsɾ��������¼
	public void deleteByIds(String ids) {
		String hql = "delete from Product p where p.id in (" + ids + ")";
		getSession().createQuery(hql).executeUpdate();
	}

	@Override
	// �����ȵ�����ѯ�Ƽ���Ʒ��������ѯǰ4����
	public List<Product> querByCategoryId(int cid) {
		String hql = "from Product p join fetch p.category "
				+ "where p.commend=true and p.open=true and p.category.id=:cid order by p.date desc";
		List<Product> list = getSession().createQuery(hql)
				.setInteger("cid", cid).setFirstResult(0)
				.setMaxResults(4)
				.list();
		return list;
	}

}
