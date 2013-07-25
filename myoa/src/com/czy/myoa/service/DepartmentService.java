package com.czy.myoa.service;

import java.util.List;

import com.czy.myoa.base.BaseDao;
import com.czy.myoa.domain.Department;

public interface DepartmentService extends BaseDao<Department>{
	
	public List<Department> getChildren(Long parentId);
	public List<Department> getTree();
	public void trvalTree(List<Department> tree,String str,List<Department> treeStr);
}
