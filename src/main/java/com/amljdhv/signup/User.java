package com.amljdhv.signup;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import com.amljdhv.consumer.Consumer;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID", nullable = false)
	private long id;

	@Column(name = "EMAIL")
	@Email(message = "*Please provide a valid Email Id")
	@NotEmpty(message = "*Please provide an email")
	private String email;

	@Column(name = "PASSWORD")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	@JsonIgnore
	private String password;
	
	@Transient
	private String usrps;

	@Column(name = "NAME")
	@NotEmpty(message = "*Please provide your name")
	private String name;

	@Column(name = "PHONE")
	private String phone;
	
	@Column(name = "LAST_NAME")
	//@NotEmpty(message = "*Please provide your last name")
	private String lastName;

	@Column(name = "ACTIVE") 
	private boolean active;

	@CreationTimestamp
	@Column(name = "created" , nullable = false)
	private Date created;


	@CreationTimestamp
	@Column(name = "updated" , nullable = false)
	private Date updated;
	
	//@NotEmpty(message = "*Please select account type")
	@Column(name = "account_type")
	private String accountType;
	
	
	private boolean online;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private Set<Role> roles; 
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "VENDOR_CONSUMER", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "C_ID"))
	private Set<Consumer> vc; 
	 
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getActive() {
		this.active = true;
		return active;
	}

	public void setActive(boolean b) {
		this.active = b;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date createdOn) {
		this.created = createdOn;
	}
	
	public Date getUpdated() {
		return updated;
	}

	
	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getUsrps() {
		return usrps;
	}

	public void setUsrps(String usrps) {
		this.usrps = usrps;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", usrps=" + usrps + ", name=" + name
				+ ", phone=" + phone + ", lastName=" + lastName + ", active=" + active + ", created=" + created
				+ ", updated=" + updated + ", accountType=" + accountType + ", online=" + online + ", roles=" + roles
				+ "]";
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public User(String email,String password,String name,String lastName, boolean active, Set<Role> roles) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.active = active;
		this.roles = roles;
	}

	public User() {
		created = new Date();
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Consumer> getVc() {
		return vc;
	}

	public void setVc(Set<Consumer> vc) {
		this.vc = vc;
	}

}
