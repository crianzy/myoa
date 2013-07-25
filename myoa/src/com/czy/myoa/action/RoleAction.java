package com.czy.myoa.action;

import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myoa.base.BaseAction;
import com.czy.myoa.domain.Privilege;
import com.czy.myoa.domain.Role;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {

	private static final long serialVersionUID = -902296382185917746L;
	private Long[] privilegeIds;

	public String list() throws Exception {
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}

	public String addUI() throws Exception {
		return "addUI";
	}

	public String add() throws Exception {
		System.out.println("roleAction ---model.rolename = "
				+ model.getRolename());
		roleService.save(model);
		return "toList";
	}

	public String editUI() throws Exception {
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().put("role", role);
		return "editUI";
	}

	public String edit() throws Exception {
		roleService.updata(model);
		return "toList";
	}

	public String del() throws Exception {
		roleService.delete(model.getId());
		return "toList";
	}

	public String setPrivilegeUI(){
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().put("role", role);
		List<Privilege> topPrivilegeList = privilegeService.getTopPrivilegList();
		ActionContext.getContext().put("topPrivilegeList", topPrivilegeList);
		//准备回显数据
		privilegeIds = new Long[role.getPrivileges().size()];
		int index = 0;
		for (Privilege privilege : role.getPrivileges()) {
			privilegeIds[index++] = privilege.getId();
		}
		return "setPrivilegeUI";
	}
	
	public String setPrivilege(){
		List<Privilege> privileges = privilegeService.getByIds(privilegeIds);
		Role role = roleService.getById(model.getId());
		role.setPrivileges(new HashSet<Privilege>(privileges));
		roleService.updata(role);
		return "toList";
	}
	
	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

}
