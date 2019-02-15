package com.amljdhv.emailVerification;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.amljdhv.signup.User;

@Entity
@Table(name = "email_verification")
public class EmailVerification {
	
	public EmailVerification() {
		created = new Date();
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "token" , length = 255)
	private String token;
	
	@Column(name = "is_expired", nullable = false)
	private boolean isExpired;
	
	@Column(name = "is_verified", nullable = false)
	private boolean isVerified;
	 
	@CreationTimestamp
	@Column(name = "created", nullable = false)
	private Date created;
	
	@CreationTimestamp
	@Column(name = "updated", nullable = false)
	private Date updated;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
	//email or payment, reward transfer
	@Column(name = "verification_type", nullable = false)
	private String verificationType;

	@Column(name = "is_verification_failed", nullable = false)
	private boolean isVerificationFailed;
	
	@Column(name = "verification_failed_reason", length = 255, nullable = true)
	private String verificationFailedReason;
	 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isExpired() {
		return isExpired;
	}

	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getVerificationType() {
		return verificationType;
	}

	public void setVerificationType(String verificationType) {
		this.verificationType = verificationType;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public boolean isVerificationFailed() {
		return isVerificationFailed;
	}

	public void setVerificationFailed(boolean isVerificationFailed) {
		this.isVerificationFailed = isVerificationFailed;
	}

	public String getVerificationFailedReason() {
		return verificationFailedReason;
	}

	public void setVerificationFailedReason(String verificationFailedReason) {
		this.verificationFailedReason = verificationFailedReason;
	}

	
	/*@PrePersist
	protected void onCreate() {
		created = new Date();
	}*/

	/*@PreUpdate
	protected void onUpdate() {
		updated = new Date();
	}*/

}
