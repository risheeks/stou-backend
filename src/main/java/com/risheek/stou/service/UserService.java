package com.risheek.stou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risheek.stou.model.User;
import com.risheek.stou.compositeKey.UserKey;
import com.risheek.stou.model.Role;
import com.risheek.stou.repository.RoleRepository;
import com.risheek.stou.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	
	@Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
	
	public User createUser(User user) {
		System.out.println(user);
		Role role = roleRepository.getById(user.getRole().getRoleId());
		user.setRole(role);
		System.out.println(user);
		return userRepository.save(user);
	}
	
	public User getUser(String email, int roleId) {
		UserKey userKey = new UserKey(email, roleRepository.getById(roleId));
		return userRepository.getOne(userKey);
	}
}
