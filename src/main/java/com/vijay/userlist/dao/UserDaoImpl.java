package com.vijay.userlist.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.vijay.userlist.entity.User;
import com.vijay.userlist.repo.UserRepo;
@Component
public class UserDaoImpl implements UserDao {
	@Autowired
	UserRepo repo;

	@Override
	public Page<User> getUsers(int offSet,int pageSize,String field) {
		Page<User> userList = repo.findAll(PageRequest.of(offSet, pageSize).withSort(Sort.by(field)));
		return userList;
	}

	@Override
	public User getUser(String email,String password) {
		User user = repo.findByEmailidAndPassword(email, password);
		return user;
	}

	@Override
	public void regUser(User user) {
		repo.save(user);
		
	}

}
