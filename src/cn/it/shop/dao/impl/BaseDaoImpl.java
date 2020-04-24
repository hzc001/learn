package cn.it.shop.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import cn.it.shop.dao.BaseDao;

/**
 * @Description TODO������ģ���DAO��ȡ��
 * @author Hzc
 *
 */
@SuppressWarnings("unchecked")
@Repository("baseDao")
@Lazy(true) // �ӳټ��أ�û��ע��֮ǰ��Ҫ���������ͻ�ʵ����bean������@Lazyע��������ڵ�һ�ε��õ�ʱ��Ż���أ�@Lazyע���������Ҫ�Ǽ���springIOC���������ļ���ʱ��
public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class clazz; // clazz�д洢�˵�ǰ���������ͣ�������T

	@Resource // �����������棬�Ͳ������set������ʹ�÷���ע���������Կ��԰�set�����ɵ���
	private SessionFactory sessionFactory;

	public BaseDaoImpl() {
		System.out.println("this������ǵ�ǰ���ù��췽���Ķ���" + this);       // 1.cn.it.shop.dao.impl.AccountDaoImpl
		System.out.println("��ȡ��ǰthis����ĸ�����Ϣ" + this.getClass().getSuperclass());  // 2.cn.it.shop.dao.impl.BaseDaoImpl
		System.out.println("��ȡ��ǰthis����ĸ�����Ϣ(����������Ϣ)" + this.getClass().getGenericSuperclass()); // 3.cn.it.shop.dao.impl.BaseDaoImpl<Account>
		// �õ����͵Ĳ�������
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0]; // 4.cn.it.shop.model.Account
		System.out.println("clazz = " + clazz);
	}

	protected Session getSession() {
		// �ӵ�ǰ�̻߳�ȡsession�����û���򴴽�һ���µ�session
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T t) {
		getSession().save(t);
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public void delete(int id) {
		System.out.println(clazz.getSimpleName());
		String hql = "delete " + clazz.getSimpleName() + " as c where c.id=:id";
		getSession().createQuery(hql) //
				.setInteger("id", id) //
				.executeUpdate();
	}

	@Override
	public T get(int id) {
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> query() {
		String hql = "from " + clazz.getSimpleName();
		List<T> list = getSession().createQuery(hql).list();
		return list;
	}

}
