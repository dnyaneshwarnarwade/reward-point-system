package com.amljdhv.signup;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "VENDOR_CONSUMER", indexes  ={
		@Index (columnList = "v_id", name ="VID"),
		@Index (columnList = "c_id", name ="CID")
}) 
public class UserConsumer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	// vendor id
	@Column(name = "v_id", nullable = false)
	private Long VID;
	
	
	// consumer id
	@Column(name = "c_id", nullable = false)
	private Long CID;
	
	@CreationTimestamp
	@Column(name = "created", nullable = false)
	private Date created;
	
	@Column(name = "updated", nullable = true)
	private Date updated;
	 
	@Column(name = "created_by", nullable = false)
	private String createdBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVID() {
		return VID;
	}

	public void setVID(Long vID) {
		VID = vID;
	}

	public Long getCID() {
		return CID;
	}

	public void setCID(Long cID) {
		CID = cID;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "UserConsumer [id=" + id + ", VID=" + VID + ", CID=" + CID + ", created=" + created + ", updated="
				+ updated + ", createdBy=" + createdBy + ", getId()=" + getId() + ", getVID()=" + getVID()
				+ ", getCID()=" + getCID() + ", getCreated()=" + getCreated() + ", getUpdated()=" + getUpdated()
				+ ", getCreatedBy()=" + getCreatedBy() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
