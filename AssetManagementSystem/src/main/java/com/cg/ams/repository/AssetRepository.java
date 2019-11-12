package com.cg.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ams.dto.Assets;
/**
* @author: SURYA
* description: Asset Repository
* created date: 04/11/2019
*/

@Repository
public interface AssetRepository extends JpaRepository<Assets,Integer>{
	public Assets findByAssetId(Integer assetId);
}