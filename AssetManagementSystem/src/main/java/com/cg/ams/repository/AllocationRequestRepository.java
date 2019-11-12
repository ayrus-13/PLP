package com.cg.ams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ams.dto.AllocationRequest;


/**
* @author: SURYA
* description: Allocation Repository
* created date: 04/11/2019
*/

@Repository
public interface AllocationRequestRepository extends JpaRepository<AllocationRequest,Integer>{
	//public AllocationRequest findByAllocationId(Integer allocationId);
	//public Allocation findByAssetName(String assetName);
	public List<AllocationRequest> findByStatus(String status);
	//public Allocation findByEmpId(Integer empId);
}
