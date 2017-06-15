package com.lskyo.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.lskyo.javabean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport {

	private User user;


	public String login(){
		ActionContext context = ActionContext.getContext();
		if(user.getUsername().equals("admin") && user.getPassword().equals("abc")){
			context.getSession().put("success", "��½�ɹ���");
			context.getSession().put("username", user.getUsername());
			return SUCCESS;
		}else{
			context.getSession().put("error", "�û������������");
			return ERROR;
		}
	}
	

	public String message(){
		ServletActionContext.getRequest().setAttribute("message", "�ɹ�ͨ��ServletActionContext�����Servlet API��");
		return "message";
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
