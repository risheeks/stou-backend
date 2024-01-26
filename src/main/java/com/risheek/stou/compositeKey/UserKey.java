package com.risheek.stou.compositeKey;

import java.io.Serializable;

import com.risheek.stou.model.Role;

public class UserKey implements Serializable {
	private String email;
	private Role role;
	public UserKey() {
		super();
	}
	public UserKey(String email, Role role) {
		super();
		this.email = email;
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
