package com.futher.school.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.futher.school.base.BaseDao;
import com.futher.school.dao.TypeMapper;
import com.futher.school.entity.Type;
import com.futher.school.entity.TypeExample;
import com.futher.school.service.TypeService;
import com.futher.school.util.PageBean;
@Service("typeService")
public class TypeServiceImpl extends BaseDao<Type,Serializable> implements TypeService{

	private static final long serialVersionUID = 1L;

	@Resource
	private TypeMapper typeMapper;

	@Override
	public Type getId(String usIdentityname) {
		return typeMapper.selectByCategoryname(usIdentityname);
	}

	@Override
	public List<Type> selectTypeName(Integer tyPid) {
		return typeMapper.selectByTypid(tyPid);
	}

	@Override
	public int addType(Type type) {
		return typeMapper.insert(type);
	}

	@Override
	public List<Type> getAllTypes() {
		return typeMapper.selectAll();
	}

	@Override
	public PageBean<Type> findByPage(int currentPage) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<Type> pageBean = new PageBean<Type>();

		// 封装当前页数
		pageBean.setCurrPage(currentPage);

		// 每页显示的数据
		int pageSize = 6;
		pageBean.setPageSize(pageSize);

		// 封装总记录数
		int totalCount = typeMapper.selectAll().size();
		pageBean.setTotalCount(totalCount);

		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		pageBean.setTotalPage(num.intValue());

		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		// 封装每页显示的数据
		List<Type> lists = typeMapper.findByPage(map);
		pageBean.setLists(lists);

		return pageBean;
	}

}
