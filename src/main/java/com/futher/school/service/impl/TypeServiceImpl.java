package com.futher.school.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.futher.school.base.BaseDao;
import com.futher.school.dao.TypeMapper;
import com.futher.school.entity.Type;
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

	@Override
	public int deletType(int tyId) {
		return typeMapper.deleteByPrimaryKey(tyId);
	}

	@Override
	public int updateType(Type type) {
		return typeMapper.updateByPrimaryKey(type);
	}

	@Override
	public Type selectTypeById(int tyId) {
		return typeMapper.selectByPrimaryKey(tyId);
	}

	@Override
	public void getType(Model model) {
		List<Type> typeList = typeMapper.selectAll();
		List<Type> general =new ArrayList<Type>();
		List<Type> dynamic =new ArrayList<Type>();
		List<Type> educate =new ArrayList<Type>();
		List<Type> literature =new ArrayList<Type>();
		if (!(typeList.isEmpty())) {
			for (int i =0; i < typeList.size(); i++) {
				if (typeList.get(i).getTyPid() == 2) {
					general.add(typeList.get(i));
					model.addAttribute("oneGeneral", general.get(0));
				} else if (typeList.get(i).getTyPid() == 3 || typeList.get(i).getTyPid() == 12|| typeList.get(i).getTyPid() == 8) {
					dynamic.add(typeList.get(i));
					model.addAttribute("oneDynamic", dynamic.get(0));
				} else if (typeList.get(i).getTyPid() == 4) {
					educate.add(typeList.get(i));
					model.addAttribute("oneEducate", educate.get(0));
				} else if (typeList.get(i).getTyPid() == 5) {
					literature.add(typeList.get(i));
					model.addAttribute("oneLiterature", literature.get(0));
				}  else if (typeList.get(i).getTyPid() == 6) {
					model.addAttribute("downloadType", typeList.get(i));
				}
			}
		}
		model.addAttribute("typeList", typeList);
		model.addAttribute("general", general);
		model.addAttribute("dynamic", dynamic);
		model.addAttribute("educate", educate);
		model.addAttribute("literature", literature);
	}

//	@Override
//	public Type selectTypeByPid(int tyPid) {
//		return null;
//	}

}

