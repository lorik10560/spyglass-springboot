package com.CrtlAltElite.spyglass.model;

import java.sql.Date;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table
public class Goals {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name ="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Lob
	@Column(name="picture", columnDefinition="BLOB")
	private byte[] picture;
	
	@Column(name="target_date")
	private Date targetDate;
	
	@Column(name="target_amount")
	private double targetAmount;
	
	@Column(name="current_amount")
	private int currentAmount;

	public Goals(long id, String name, String description, byte[] picture, Date targetDate, double targetAmount,
			int currentAmount) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.picture = picture;
		this.targetDate = targetDate;
		this.targetAmount = targetAmount;
		this.currentAmount = currentAmount;
	}

	public Goals(String name, String description, byte[] picture, Date targetDate, double targetAmount,
			int currentAmount) {
		super();
		this.name = name;
		this.description = description;
		this.picture = picture;
		this.targetDate = targetDate;
		this.targetAmount = targetAmount;
		this.currentAmount = currentAmount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public double getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(double targetAmount) {
		this.targetAmount = targetAmount;
	}

	public int getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(int currentAmount) {
		this.currentAmount = currentAmount;
	}

	@Override
	public String toString() {
		return "Goals [id=" + id + ", name=" + name + ", description=" + description + ", picture="
				+ Arrays.toString(picture) + ", targetDate=" + targetDate + ", targetAmount=" + targetAmount
				+ ", currentAmount=" + currentAmount + "]";
	}
	
}
