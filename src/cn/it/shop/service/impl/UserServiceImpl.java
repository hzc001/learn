package cn.it.shop.service.impl;

import org.springframework.stereotype.Service;
import cn.it.shop.model.User;
import cn.it.shop.service.UserService;

/**
 * �û���¼��ҵ���ʵ����
 * @author Hzc
 *
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Override
	// �û���½���ɹ����ظ�User
	public User login(User user) {
		return userDao.login(user);
	}

}
