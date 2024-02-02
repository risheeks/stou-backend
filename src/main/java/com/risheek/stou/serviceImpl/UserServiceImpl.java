package com.risheek.stou.serviceImpl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.risheek.stou.compositeKey.UserKey;
import com.risheek.stou.model.Role;
import com.risheek.stou.model.User;
import com.risheek.stou.repository.RoleRepository;
import com.risheek.stou.repository.UserRepository;
import com.risheek.stou.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private BCryptPasswordEncoder bCrypt;
	
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
    	super();
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCrypt = new BCryptPasswordEncoder();
    }
	
	public User createUser(User user) {
		if(userExists(user.getEmail(), user.getRole().getRoleId())) return null;
		Role role = roleRepository.getReferenceById(user.getRole().getRoleId());
		user.setRole(role);
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		user.setPassword(bCrypt.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	public boolean authenticateUser(User user) {
		if(userExists(user.getEmail(), user.getRole().getRoleId())) {
			UserKey userKey = new UserKey(user.getEmail(), roleRepository.getReferenceById(user.getRole().getRoleId()));
			User dbUser = null;
			dbUser = userRepository.getReferenceById(userKey);
			if(this.bCrypt.matches(user.getPassword(), dbUser.getPassword())) {
				System.out.println("Authentication Successful " + dbUser);
				return true;
			}
		}
		System.out.println("Authentication Failed");
		return false;
	}
	
	public boolean userExists(String email, int roleId) {
		UserKey userKey = new UserKey(email, roleRepository.getReferenceById(roleId));
		System.out.println("userExists called with key: " + userKey);
		return userRepository.existsById(userKey);
	}
	
	public User getUser(String email, int roleId) {
		if(!userExists(email, roleId)) return null;
		UserKey userKey = new UserKey(email, roleRepository.getReferenceById(roleId));
		User user = userRepository.getReferenceById(userKey);
		user.setPassword("");
		return user;
	}
}
