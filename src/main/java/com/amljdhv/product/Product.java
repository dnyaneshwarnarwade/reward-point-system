package com.amljdhv.product;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.amljdhv.signup.User;


@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "SKU")
	private String SKU;
	
	@Column(name = "NAME")
	private String productName;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "PRICE")
	private BigDecimal price;
	
	@Column(name = "DISCOUNT")
	private BigDecimal discount;
	
	@Column(name = "rewardPoints")
	private int rewardPoints;
	
	@Column(name = "ISREWARDENABLED")
	private Boolean isRewardEnabled;
	
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "product_detail_id") 
//	private ProductDetail productDetail;
	
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;



	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getSKU() {
		return SKU;
	}


	public void setSKU(String sKU) {
		SKU = sKU;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public BigDecimal getDiscount() {
		return discount;
	}


	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}


	public int getRewardPoints() {
		return rewardPoints;
	}


	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}


	public Boolean getIsRewardEnabled() {
		return isRewardEnabled;
	}


	public void setIsRewardEnabled(Boolean isRewardEnabled) {
		this.isRewardEnabled = isRewardEnabled;
	}

	
}

/**
 * we should save the product related information suggested by the 
 * https://www.practicalecommerce.com/A-Better-Way-to-Store-Ecommerce-Product-Information
 * 
 *  ID , SKU , TITLE , WAIST , INSEAM , COLOR
*/