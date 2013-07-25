package com.czy.myoa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.czy.myoa.base.BaseDao;
import com.czy.myoa.base.BaseDaoImpl;
import com.czy.myoa.domain.Department;
import com.czy.myoa.service.DepartmentService;

@Service
public class DepartmentServiceImpl extends BaseDaoImpl<Department> implements
		DepartmentService, BaseDao<Department> {

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getChildren(Long parentId) {
		Session session = getSession();
		if (parentId == null) {
			return session.createQuery(
					"FROM Department d WHERE d.parent = null")//
					.list();
		}
		Department parnet = (Department) session
				.get(Department.class, parentId);
		List<Department> chidren = new ArrayList<Department>(
				parnet.getChildren());
		return chidren;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Department> getTree() {
		Session session = getSession();
		return session.createQuery("FROM Department d WHERE d.parent = null")//
				.list();
	}

	@Override
	public void trvalTree(List<Department> tree, String str,
			List<Department> treeStr) {
		for (Department department : tree) {
			Department depart = new Department();
			depart.setId(department.getId());
			depart.setDepartmentName(str + department.getDepartmentName());
			treeStr.add(depart);
			trvalTree(new ArrayList<Department>(department.getChildren()), str
					+ "　", treeStr);
		}
	}
}
