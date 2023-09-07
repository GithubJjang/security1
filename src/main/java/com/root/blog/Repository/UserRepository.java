package com.root.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.root.blog.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsername(String username);
	
}


