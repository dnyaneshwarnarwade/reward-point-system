package com.amljdhv.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "user_detail")
public class UserDetail {
	
	
	/// phone, address, dob
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_detail_id" , nullable = false)
	private long userDetailId;
	
	@Column(name = "mobile_no", nullable = true)
	@Length(min = 10, message = "*Mobile no should have 10 digits")
	private String mobileNo;
	
	@Column(name = "address", nullable = true)
	private String address;
	
	@Column(name = "dob", nullable = true)
	private String dob;
	
	@Column(name = "city", nullable = true)
	private String city;
	
	@Column(name = "state", nullable = true)
	private String state;
	
	@Column(name = "country", nullable = true)
	private String country;
	
	@Column(name = "pin", nullable = true)
	private String pin;
	
	@Column(name = "alternative_mobile_no", nullable = true)
	@Length(min = 10, message = "*Mobile no should have 10 digits")
	private String alternativeMobileNo;
	
	@Column(name = "gender", nullable = true)
	private String gender;

	public long getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(long userDetailId) {
		this.userDetailId = userDetailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getAlternativeMobileNo() {
		return alternativeMobileNo;
	}

	public void setAlternativeMobileNo(String alternativeMobileNo) {
		this.alternativeMobileNo = alternativeMobileNo;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "UserDetail [userDetailId=" + userDetailId + ", mobileNo=" + mobileNo + ", address=" + address + ", dob="
				+ dob + ", city=" + city + ", state=" + state + ", country=" + country + ", pin=" + pin
				+ ", alternativeMobileNo=" + alternativeMobileNo + "]";
	}
	
	
	

}
