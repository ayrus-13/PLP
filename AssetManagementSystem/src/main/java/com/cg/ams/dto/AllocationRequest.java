package com.cg.ams.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
* @author: SURYA
* description: Assets Model
* created date: 04/11/2019
*/

@Entity
@Table(name="AllocationRequest")
public class AllocationRequest {
	@Id
	@Column(name="user_id")
	private User userId;
	
	@Column(name="asset_id")
	private Assets assetId;
	
	@Column(name="date")
	private LocalDate dateandTime;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name="status")
	private String status;
	
	
	public AllocationRequest() {
		super();
	}
	
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	
	public Assets getAssetId() {
		return assetId;
	}
	public void setAssetId(Assets assetId) {
		this.assetId = assetId;
	}
	public LocalDate getDateandTime() {
		return dateandTime;
	}
	public void setDateandTime(LocalDate dateandTime) {
		this.dateandTime = dateandTime;
	}
	@Override
	public String toString() {
		return "AllocationRequest [userId=" + userId + ",  assetId=" + assetId + ", dateandTime="
				+ dateandTime + ", status=" + status + "]";
	}
	public AllocationRequest(User userId, Assets assetId, LocalDate dateandTime, String status) {
		super();
		this.userId = userId;
		
		this.assetId = assetId;
		this.dateandTime = dateandTime;
		this.status = status;
	}
	
	
	

}
