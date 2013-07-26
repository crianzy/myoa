package com.czy.myoa.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myoa.service.DepartmentService;
import com.czy.myoa.service.ForumService;
import com.czy.myoa.service.PrivilegeService;
import com.czy.myoa.service.RoleService;
import com.czy.myoa.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	private static final long serialVersionUID = 5280012407225278434L;

	@Resource
	protected RoleService roleService;

	@Resource
	protected UserService userService;
	
	@Resource
	protected DepartmentService departmentService;
	
	@Resource
	protected PrivilegeService privilegeService;
	
	@Resource
	protected ForumService forumService;

	protected T model;

	/**
	 * 构造函数 通过反射初始化 model
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseAction() {
		try {
			ParameterizedType pt = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			Class clazz = (Class) pt.getActualTypeArguments()[0];
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public T getModel() {
		return model;
	}
}
