package com.czy.myoa.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myoa.base.BaseAction;
import com.czy.myoa.domain.Department;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {

	private static final long serialVersionUID = 2641684287934378035L;

	private Long parentId;

	public String list() throws Exception {
		List<Department> departmentList = departmentService
				.getChildren(parentId);
		if(parentId!=null){
			Department parent = departmentService.getById(parentId);
			Long parent_parentId = parent.getParent()==null ? null:parent.getParent().getId();
			ActionContext.getContext().put("parent_parentId", parent_parentId);
		}
		ActionContext.getContext().put("departmentList", departmentList);
		return "list";
	}

	public String addUI() {
		// 进行树状结构的展现
		List<Department> tree = departmentService.getTree();
		List<Department> departmentTreeStr = new ArrayList<Department>();
		departmentService.trvalTree(tree, "┠", departmentTreeStr);
		ActionContext.getContext().put("departmentTreeStr", departmentTreeStr);
		if(parentId!=null){
			Department parent = departmentService.getById(parentId);
			Long parent_parentId = parent.getParent()==null ? null:parent.getParent().getId();
			ActionContext.getContext().put("parent_parentId", parent_parentId);
		}
		return "addUI";
	}

	public String add() {
		Department parent = departmentService.getById(parentId);
		model.setParent(parent);
		departmentService.save(model);
		return "toList";
	}

	public String editUI() {
		// 进行树状结构的展现
		List<Department> tree = departmentService.getTree();
		List<Department> departmentTreeStr = new ArrayList<Department>();
		departmentService.trvalTree(tree, "┠", departmentTreeStr);
		ActionContext.getContext().put("departmentTreeStr", departmentTreeStr);

		Department department = departmentService.getById(model.getId());
		ActionContext.getContext().put("department", department);
		if (department.getParent() != null) {
			parentId = department.getParent().getId();
		}
		return "editUI";
	}

	public String edit() {
		Department parent = departmentService.getById(parentId);
		model.setParent(parent);
		departmentService.updata(model);
		return "toList";
	}

	public String del() {
		departmentService.delete(model.getId());
		return "toList";
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
