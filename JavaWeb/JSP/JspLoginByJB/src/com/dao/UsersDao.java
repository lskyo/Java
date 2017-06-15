package com.dao;

import com.po.Users;

public class UsersDao {

	public boolean usersLogin(Users users) {
		if ("admin".equals(users.getUsername()) && "admin".equals(users.getPassword())) {
			return true;
		}else
			return false;
	}
}
