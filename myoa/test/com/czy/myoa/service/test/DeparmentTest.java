package com.czy.myoa.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.czy.myoa.domain.Department;
import com.czy.myoa.service.DepartmentService;

public class DeparmentTest {
	ApplicationContext ac = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	@Test
	public void getTreeTest() {
		DepartmentService departmentService = (DepartmentService) ac.getBean("departmentServiceImpl");
		List<Department> tree = departmentService.getTree();
		for (Department department : tree) {
			System.out.println("  "+department.getDepartmentName());
		}
		List<Department> treeStr = new ArrayList<Department>();
		trvalTree(tree, "--",treeStr);
		for (Department str : treeStr) {
			System.out.println(str.getDepartmentName());
		}
	}
	
	public void trvalTree(List<Department> tree,String str,List<Department> treeStr){
		for (Department department : tree) {
			Department depart = new Department();
			depart.setId(department.getId());
			depart.setDepartmentName(str+department.getDepartmentName());
			treeStr.add(depart);
			trvalTree(new ArrayList<Department>(department.getChildren()) , str+"--",treeStr);
		}
	}
}
