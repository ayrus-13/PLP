package com.cg.ams.dto;

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
@Table(name="Asset")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Assets {
	@Id
	@Column(name="asset_id")
	private Integer assetId;

	@Column(name="asset_name")
	private String assetName;

	@Column(name="quantity")
	private Integer quantity;

	public Assets() {
		super();
	}

	public Assets(Integer assetId, String assetName, String assetDesc, Integer quantity, String status) {
		super();
		this.assetId = assetId;
		this.assetName = assetName;
		this.quantity = quantity;
		
	}

	public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Assets [assetId=" + assetId + ", assetName=" + assetName + ", quantity=" + quantity + "]";
	}


	
	
	

}
