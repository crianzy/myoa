package com.czy.myoa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myoa.base.BaseAction;
import com.czy.myoa.domain.Forum;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class ForumManageAction extends BaseAction<Forum> {

	private static final long serialVersionUID = 3016209977263500686L;

	public String list() throws Exception {
		List<Forum> forumList = forumService.findAll();
		ActionContext.getContext().put("forumList", forumList);
		return "list";
	}

	public String addUI() {
		// 进行树状结构的展现
		return "addUI";
	}

	public String add() {
		forumService.save(model);
		return "toList";
	}

	public String editUI() {
		Forum forum = forumService.getById(model.getId());
		ActionContext.getContext().put("forum", forum);
		return "editUI";
	}

	public String edit() {
		forumService.updata(model);
		return "toList";
	}

	public String del() {
		forumService.delete(model.getId());
		return "toList";
	}
	
	public String moveUp(){
		forumService.moveUp(model.getId());
		return "toList";
	}
	
	public String moveDown(){
		forumService.moveDown(model.getId());
		return "toList";
	}
}
