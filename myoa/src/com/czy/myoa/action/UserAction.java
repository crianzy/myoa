package com.czy.myoa.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myoa.base.BaseAction;
import com.czy.myoa.domain.Department;
import com.czy.myoa.domain.Role;
import com.czy.myoa.domain.User;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	private static final long serialVersionUID = 5091253812894575460L;

	private Long[] roleIds;
	private Long departmentId;

	public String list() throws Exception {
		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);
		return "list";
	}

	public String addUI() throws Exception {
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		// 部门树桩结构展现
		List<Department> tree = departmentService.getTree();
		List<Department> departmentTreeStr = new ArrayList<Department>();
		departmentService.trvalTree(tree, "┠", departmentTreeStr);
		ActionContext.getContext().put("departmentTreeStr", departmentTreeStr);
		return "addUI";
	}

	public String add() throws Exception {
		// 添加 roleList
		List<Role> roleList = roleService.getByIds(roleIds);
		model.setRoles(new HashSet<Role>(roleList));
		// 添加部门
		Department department = departmentService.getById(departmentId);
		model.setDepartment(department);
		model.setPassword("1234");
		userService.save(model);
		return "toList";
	}

	public String editUI() throws Exception {
		// roleList 的回显数据
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		// 部门树桩结构展现
		List<Department> tree = departmentService.getTree();
		List<Department> departmentTreeStr = new ArrayList<Department>();
		departmentService.trvalTree(tree, "┠", departmentTreeStr);
		ActionContext.getContext().put("departmentTreeStr", departmentTreeStr);
		// user 的回显数据
		User user = userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		// 回显 选中的 role
		if (user.getRoles().size() > 0) {
			roleIds = new Long[user.getRoles().size()];
			int index = 0;
			for (Role role : user.getRoles()) {
				roleIds[index++] = role.getId();
			}
		}
		// 回显部门
		if (user.getDepartment() != null) {
			departmentId = user.getDepartment().getId();
		}
		return "editUI";
	}

	public String edit() throws Exception {
		// 添加 roleList
		List<Role> roleList = roleService.getByIds(roleIds);
		model.setRoles(new HashSet<Role>(roleList));
		// 添加部门
		Department department = departmentService.getById(departmentId);
		model.setDepartment(department);
		userService.updata(model);
		return "toList";
	}

	public String del() throws Exception {
		userService.delete(model.getId());
		return "toList";
	}

	public String initPassword() throws Exception {
		User user = userService.getById(model.getId());
		user.setPassword(DigestUtils.md5Hex("1234"));
		userService.updata(user);
		return "toList";
	}
	
	public String loginUI(){
		return "loginUI";
	}
	
	public String login(){
		System.out.println(model.getLoginName()+"-------------"+model.getPassword());
		User user = userService.getUserByLoginNamePassword(model.getLoginName(), DigestUtils.md5Hex(model.getPassword()));
		if(user!=null){
			ActionContext.getContext().getSession().put("user", user);
			return "toIndex";
		}else{
			addFieldError("login", "用户或密码不正确");
			return "loginUI";
		}
	}
	
	
	public Long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

}
