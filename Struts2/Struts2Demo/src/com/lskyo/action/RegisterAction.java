package com.lskyo.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{

	private String username;
	private String password1;
	private String password2;

	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		if(username!=null && !getUsername().trim().equals("") && getPassword1().equals(getPassword2())){
			context.getSession().put("success", "注册成功！");
			context.getSession().put("username", username);
			return SUCCESS;
		}else{
			context.getSession().put("error", "用户名重复或输入有误！");
			return ERROR;
		}
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
}
