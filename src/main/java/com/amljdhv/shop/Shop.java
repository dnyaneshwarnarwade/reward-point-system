package com.amljdhv.shop;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;

import com.amljdhv.signup.User;

@Entity
@Table(name = "SHOP")
public class Shop {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SHOP_ID")
	private long shopId;
	
	@Column(name="SHOP_NAME")
	@NotEmpty(message = "*Please provide shop name")
	private String shopName;
	
	@Column(name="REGISTRATION_NUMBER")
	@NotEmpty(message = "*Please provide registration number")
	private String registrationNumber;
	
	@CreationTimestamp
	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;

	@Column(name = "LOCATION", nullable = false)
	@NotEmpty(message = "*Please provide location")
	private String location;
	
	@NotEmpty(message = "*Please provide pinCode")
	@Column(name = "PIN_CODE", nullable = false)
	private String pinCode;
	
	@NotEmpty(message = "*Please select country")
	@Column(name = "COUNTRY", nullable = false)
	private String country;
	
	@NotEmpty(message = "*Please select state")
	@Column(name = "STATE", nullable = false)
	private String state;

	
	@NotEmpty(message = "*Please provide shop established year or date")
	@Column(name = "ESTABLISHED_DATE", nullable = false)
	private String establishedDate;

	@Column(name = "ACTIVE", nullable = false)
	private boolean active;

	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEstablishedDate() {
		return establishedDate;
	}

	public void setEstablishedDate(String establishedDate) {
		this.establishedDate = establishedDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Shop [id=" + shopId + ", shopName=" + shopName + ", registrationNumber=" + registrationNumber
				+ ", createdDate=" + createdDate + ", location=" + location + ", pinCode=" + pinCode + ", country="
				+ country + ", state=" + state + ", establishedDate=" + establishedDate + ", active=" + active + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
