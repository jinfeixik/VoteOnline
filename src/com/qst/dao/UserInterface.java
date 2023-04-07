package com.qst.dao;

import java.util.List;

import com.qst.entity.User;


public interface UserInterface {
	public void addUser(User user);
	public User loginUser(String VU_USER_NAME, String VU_PASSWORD);
	public int findUserId(String VU_USER_NAME);
	public List<User> findUsers();
}
