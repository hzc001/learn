package cn.it.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

/**
 * ��Ʒ����ҵ���ʵ����
 * @author Hzc
 *
 */
@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

	@Override
	// ��ѯ�����Ϣ����������Ա
	public List<Category> queryJoinAccount(String type, int page, int size) {
		return categoryDao.queryJoinAccount(type, page, size);
	}

	@Override
	// ���ݹؼ��ֲ�ѯ�ܼ�¼��
	public Long getCount(String type) {
		return categoryDao.getCount(type);
	}

	@Override
	// ����idsɾ��������¼
	public void deleteByIds(String ids) {
		categoryDao.deleteByIds(ids);
	}

	@Override
	// ����boelenֵ��ѯ�ȵ����ȵ����
	public List<Category> queryByHot(boolean hot) {
		return categoryDao.queryByHot(hot);
	}
}
