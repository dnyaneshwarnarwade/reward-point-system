package com.amljdhv.signup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ROLE_ID", nullable = false)
	private long id;
	
	@Column( nullable = false)
	private String role;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_USER = "ROLE_USER";
	public static final String ROLE_CUSTOMER = "ROLE_CUSTOMER";
	public static final String ROLE_CHILD = "ROLE_CHILD";
	public static final String BUSINESS_CHILD = "BUSINESS_CHILD";
}
