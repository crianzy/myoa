package com.czy.myoa.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.czy.myoa.domain.Privilege;
import com.czy.myoa.service.PrivilegeService;

public class InitServletContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		//得到service实力对象
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(application);
		PrivilegeService privilegeService = (PrivilegeService) ac.getBean("privilegeServiceImpl");
		//准备所有顶级权限数据
		List<Privilege> topPrivilegeList = privilegeService.getTopPrivilegList();
		application.setAttribute("topPrivilegeList", topPrivilegeList);
		//ActionContext.getContext().getApplication().put("topPrivilegeList", topPrivilegeList);
		System.out.println("--已经准备好顶级权限数据--");
		//准备所有权限数据的url集合
		List<String> allPrivilegeUrlList = privilegeService.getAllPrivilegUrlList();
		application.setAttribute("allPrivilegeUrlList", allPrivilegeUrlList);
		//ActionContext.getContext().getApplication().put("allPrivilegUrlLisr", allPrivilegeUrlList);
		System.out.println("--已经准备好URL权限数据--");
	}


}
