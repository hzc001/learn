package cn.it.shop.dao;

import cn.it.shop.model.User;

/**
 * �û���DAO�ӿ�
 * @author Hzc
 *
 */
public interface UserDao extends BaseDao<User> {
	// �û���½���ɹ����ظ�User
	public User login(User user);
}
