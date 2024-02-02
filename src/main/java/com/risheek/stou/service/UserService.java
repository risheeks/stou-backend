package com.risheek.stou.service;

import com.risheek.stou.model.User;

public interface UserService {
		
	public User createUser(User user);
	
	public boolean authenticateUser(User user);
	
	public boolean userExists(String email, int roleId);
	
	public User getUser(String email, int roleId);
}
