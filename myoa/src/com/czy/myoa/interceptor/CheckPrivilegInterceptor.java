package com.czy.myoa.interceptor;

import com.czy.myoa.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckPrivilegInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = -3500941489004154598L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//获取当前用户
		User user = (User) ActionContext.getContext().getSession().get("user");
		//获取当前访问的url 并去掉前缀后缀
		String nameSpace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();
		String privilegeUrl = null;
		if(nameSpace.endsWith("/")){
			privilegeUrl = nameSpace+actionName;
		}else{
			privilegeUrl = nameSpace+"/"+actionName;
		}
		//去掉开头的'/'
		if(privilegeUrl.startsWith("/")){
			privilegeUrl = privilegeUrl.substring(1);
		}
		if(user==null){//如果用户未登录
			if(privilegeUrl.startsWith("userAction_login")){
				return invocation.invoke();
			}else{
				return "loginUI";
			}
		}else{
			if(user.hasPrivilegeByUrl(privilegeUrl)){
				return invocation.invoke();
			}else{
				return "noPrivilegeError";
			}
		}
	}

}
