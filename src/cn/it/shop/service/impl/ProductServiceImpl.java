package cn.it.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.it.shop.model.Product;
import cn.it.shop.service.ProductService;

/**
 * ��Ʒ��ҵ���ʵ����
 * @author Hzc
 *
 */
@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

	@Override
	// ��ѯ��Ʒ��Ϣ���������
	public List<Product> queryJoinCategory(String name, int page, int size) {
		return productDao.queryJoinCategory(name, page, size);
	}

	@Override
	// ���ݹؼ��ֲ�ѯ�ܼ�¼��
	public Long getCount(String name) {
		return productDao.getCount(name);
	}

	@Override
	// ����idsɾ��������¼
	public void deleteByIds(String ids) {
		productDao.deleteByIds(ids);
	}

	@Override
	// �����ȵ�����ѯ�Ƽ���Ʒ��������ѯǰ4����
	public List<Product> querByCategoryId(int cid) {
		return productDao.querByCategoryId(cid);
	}

}
