package com.lskyo.spring.beans.annotation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lskyo.spring.beans.annotation.TestObject;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired(required=false)
	private TestObject testObject;
	
	@Override
	public void save() {
		System.out.println("UserRepository save....");
		System.out.println(testObject);
	}

}
