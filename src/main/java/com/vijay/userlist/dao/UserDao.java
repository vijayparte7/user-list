package com.vijay.userlist.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.vijay.userlist.entity.User;

@Component
public interface UserDao {
	Page<User> getUsers(int offSet,int pageSize,String field);
	User getUser(String email, String password);
	void regUser(User user);
}
