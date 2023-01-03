package com.vijay.userlist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.vijay.userlist.entity.User;
@Component
public interface UserRepo extends JpaRepository<User, Long> {
	User findByEmailidAndPassword(String email, String password);
}
