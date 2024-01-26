package com.risheek.stou.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	int roleId;
	
	@Column(name = "role_desc")
	String roleDesc;
	
	public Role() {
		super();
	}

	public Role(int roleId, String roleDesc) {
		super();
		this.roleId = roleId;
		this.roleDesc = roleDesc;
	}
	
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleDesc=" + roleDesc + "]";
	}
	
}
