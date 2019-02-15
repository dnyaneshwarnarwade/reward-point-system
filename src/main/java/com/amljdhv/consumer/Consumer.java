 
package com.amljdhv.consumer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.amljdhv.signup.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="CONSUMER")
public class Consumer {

	@Column(name = "C_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long CID;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "PHONE")
	private String phone;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Transient
	@JsonIgnore
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "DOB")
	private String dob;
	
	@Column(name ="COMMENT")
	private String comment;
	
	@Column(name = "SEARCH_STRING", length = 1000)
	private String searchString;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

/*	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User vendor;
*/
	public String getFirstName() {
		return firstName; 
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Long getCID() {
		return CID;
	}

	public void setCID(Long cID) {
		CID = cID;
	}

/*	public User getVendor() {
		return vendor;
	}

	public void setVendor(User vendor) {
		this.vendor = vendor;
	}
*/

	
}
