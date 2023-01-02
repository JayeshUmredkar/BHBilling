package com.brainhunter.bhbilling.dto;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class SellProductDto {

	private int id;
	private int quantity;
	private double sellingDiscount;
	private Date sellingAt;
	@CreationTimestamp
	private Date createdAt;
	@UpdateTimestamp
	private Date updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSellingDiscount() {
		return sellingDiscount;
	}

	public void setSellingDiscount(double sellingDiscount) {
		this.sellingDiscount = sellingDiscount;
	}

	public Date getSellingAt() {
		return sellingAt;
	}

	public void setSellingAt(Date sellingAt) {
		this.sellingAt = sellingAt;
	}

}
