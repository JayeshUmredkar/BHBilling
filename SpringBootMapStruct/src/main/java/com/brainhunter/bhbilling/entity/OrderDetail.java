package com.brainhunter.bhbilling.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "order_details")
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private double totalAmount;
	private double discountAmount;
	private double payingAmount;
	private double sgstPrice;
	private double cgstPrice;
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

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getPayingAmount() {
		return payingAmount;
	}

	public void setPayingAmount(double payingAmount) {
		this.payingAmount = payingAmount;
	}

	public double getSgstPrice() {
		return sgstPrice;
	}

	public void setSgstPrice(double sgstPrice) {
		this.sgstPrice = sgstPrice;
	}

	public double getCgstPrice() {
		return cgstPrice;
	}

	public void setCgstPrice(double cgstPrice) {
		this.cgstPrice = cgstPrice;
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

}
