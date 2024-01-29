package com.risheek.stou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	private BCryptPasswordEncoder bCrypt;
	
	@Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCrypt = new BCryptPasswordEncoder();
    }
	
	public User createUser(User user) {
		Role role = roleRepository.getById(user.getRole().getRoleId());
		user.setRole(role);
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		user.setPassword(bCrypt.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	public boolean authenticateUser(User user) {
		UserKey userKey = new UserKey(user.getEmail(), roleRepository.getById(user.getRole().getRoleId()));
		User dbUser = userRepository.getById(userKey);
		return this.bCrypt.matches(user.getPassword(), dbUser.getPassword());
	}
	
	public User getUser(String email, int roleId) {
		UserKey userKey = new UserKey(email, roleRepository.getById(roleId));
		User user = userRepository.getById(userKey);
		user.setPassword("");
		return user;
	}
}
