package cn.it.shop.service;

import cn.it.shop.model.User;

/**
 * �û���¼��ҵ���ӿ�
 * @author Hzc
 *
 */
public interface UserService extends BaseService<User> {
	// �û���½���ɹ����ظ�User
	public User login(User user);
}
