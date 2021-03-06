package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Category;

@Controller("categoryAction")
@Scope("prototype") // prototype表示每次获得bean都会生成一个新的对象，设置为多例模式
public class CategoryAction extends BaseAction<Category> {

	private static final long serialVersionUID = 2343749735858232285L;

	// 查询类别信息，级联管理员
	public String queryJoinAccount() {
		System.out.println("type:" + model.getType());
		System.out.println("page：" + page);
		System.out.println("rows：" + rows);

		// 用来存储分页的数据
		pageMap = new HashMap<String, Object>();

		// 根据关键字和分页的参数查询相应的数据
		List<Category> categoryList = categoryService.queryJoinAccount(model.getType(), page, rows);
		pageMap.put("rows", categoryList); // 存储为JSON格式
		// 根据关键字查询总记录数
		Long total = categoryService.getCount(model.getType());
//		System.out.println(total);
		pageMap.put("total", total); // 存储为JSON格式

		return "jsonMap";
	}

	// 根据ids删除多条记录
	public String deleteByIds() {
		System.out.println(ids);
		categoryService.deleteByIds(ids);
		// 如果删除成功就会往下执行，我们将"true"以流的形式传给前台
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}

	public void save() {
		System.out.println(model);
		categoryService.save(model);
	}

	public void update() {
		System.out.println(model);
		categoryService.update(model);
	}

	public String query() {
		jsonList = categoryService.query();
		return "jsonList";
	}
}
