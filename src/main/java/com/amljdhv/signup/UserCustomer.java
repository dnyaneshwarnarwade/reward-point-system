package com.amljdhv.signup;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;


/**
 * <p> This table is used when shop owner will register the consumer </p>
 * 
 * <blockquote>
 * DESC : During the registration of the consumer, this table would take 5 parameter
 * 	 
 * 1 -> id, is a primary key for this table
 * 2 -> customer_id, is belong to the `User` table is a foreign key in current table. 
 * 3 -> user_id, is belong to the `User` table is foreign key in the current table
 * 4 -> created_on, is basically take created date (TimeStamp).
 * 5 -> created_by, which is logged-in user. 
 */
//@Entity
//@Table(name = "user_customer", indexes = {
//		@Index(columnList = "user_id", name = "user_id"),
//		@Index(columnList = "customer_id", name = "customer_id")})
public class UserCustomer {/*

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private long id;
	
	@Column(nullable =false)
	private long customer_id;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user; 
	

	@CreationTimestamp
	@Column( nullable = false)
	private Date created_on;
	
	@Column(nullable = false)
	@NotEmpty(message = "*Please provide a created_by")
	private String created_by;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public Date getCreated() {
		return created_on;
	}

	public void setCreated(Date created) {
		this.created_on = created;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	

*/}
