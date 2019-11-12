package com.cg.ams.controller;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ams.AssetManagementSystemApplication;
import com.cg.ams.dto.AllocationRequest;
import com.cg.ams.dto.Assets;
import com.cg.ams.exception.AmsException;
import com.cg.ams.service.AssetManagementService;






@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AssetManagementController {
	
	@Autowired
	AssetManagementService assetManagementService;

	private static final Logger logger = LoggerFactory.getLogger(AssetManagementSystemApplication.class);
	
	@PostMapping(value="/add")
	public ResponseEntity<Assets> addAsset(@ModelAttribute Assets asset) throws AmsException{
		Assets assetToBeAdded=assetManagementService.addAsset(asset);
		System.out.println(asset);
		if(assetToBeAdded==null)
			return new ResponseEntity("Asset not added", HttpStatus.INTERNAL_SERVER_ERROR);
		else
			return new ResponseEntity<Assets>(assetToBeAdded,HttpStatus.OK);
		}
	

	@GetMapping(value = "/showassets")
	public ResponseEntity<List<Assets>> viewAssets() {							

		List<Assets> assetList = assetManagementService.viewAssets();
		if (assetList.isEmpty()) {
			return new ResponseEntity("No Asset Present", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<Assets>>(assetList, HttpStatus.OK);
		}
	}
	
	
	@GetMapping(value="/searchasset")
	public ResponseEntity<Assets> viewAssets(@RequestParam Integer assetId) throws AmsException{					
		Assets searchAsset=assetManagementService.viewAssets(assetId);
		
		if (searchAsset == null) {
			return new ResponseEntity("Asset not present", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Assets>(searchAsset, HttpStatus.OK);
		}
		
	}
	
	
	@PutMapping(value="/modifyasset")
	public ResponseEntity<Assets> modifyAsset(@ModelAttribute Assets asset) throws AmsException{			
		
		Assets modifyAssets=assetManagementService.modifyAsset(asset);
		
		if (modifyAssets == null) {
			return new ResponseEntity("Asset not modified", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Assets>(modifyAssets, HttpStatus.OK);
		}
		
	}
	
	
	@DeleteMapping(value="/deleteasset")
	public boolean deleteAsset(@RequestParam Integer assetId) throws AmsException{					
		
		boolean assetToBeDeleted=assetManagementService.deleteAsset(assetId);
		
		return assetToBeDeleted;
		
	}
	
	
	@GetMapping(value = "/showallocation")
	public ResponseEntity<List<AllocationRequest>> viewAllocation() {							

		List<AllocationRequest> allocationList = assetManagementService.viewAllocation();
		if (allocationList.isEmpty()) {
			return new ResponseEntity("No Asset allocated", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<AllocationRequest>>(allocationList, HttpStatus.OK);
		}
	}
	
	
	@GetMapping(value = "/showbystatus")
	public ResponseEntity<List<AllocationRequest>> searchAllocationByStatus(@RequestParam String status) throws AmsException {							

		List<AllocationRequest> allocationList = assetManagementService.searchAllocationByStatus(status);
		if (allocationList.isEmpty()) {
			return new ResponseEntity("No Asset for this status", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<AllocationRequest>>(allocationList, HttpStatus.OK);
		}
	}
	
	@PostMapping(value="/approveRequest")
	public String approveAllocationRequest(@RequestParam("allocationId") Integer allocationId,Map<String,Object> model) throws AmsException {
		
		try {
			assetManagementService.approveAllocationRequest(allocationId);
			
		} catch (Exception e) {
			
			return "not done";
		}
		return "Done";
	}
	
	@PostMapping(value="/rejectRequest")
	public String rejectAllocationRequest(@RequestParam("allocationId") Integer allocationId,Map<String,Object> model) {
		
		try {
			assetManagementService.rejectAllocationRequest(allocationId);
			
		} catch (Exception e) {
			
			return "not done";
		}
		return "Done";
	}
	
	@GetMapping(value = "/checkRequestStatus")
	public ResponseEntity<AllocationRequest> checkRequestStatus(@RequestParam("applicationId") Integer requestId) throws AmsException {

		AllocationRequest allocationRequest = assetManagementService.checkAllocationStatus(requestId);
		if (allocationRequest == null) {
			return new ResponseEntity<AllocationRequest>(HttpStatus.NO_CONTENT);
		} else {

			return new ResponseEntity<AllocationRequest>(allocationRequest, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/viewRequestsToBeApproved")
	public ResponseEntity<List<AllocationRequest>> viewRequestsToBeApproved() {
		
		List<AllocationRequest> requests = assetManagementService.getRequestsToApprove();
		return new ResponseEntity<List<AllocationRequest>>(requests,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getRequests")
	public ResponseEntity<?> getRequests() {

		List<AllocationRequest> allocationRequests = assetManagementService.viewRequests();
		if (allocationRequests.size() == 0) {
			return new ResponseEntity<String>("No Loan Request", HttpStatus.NO_CONTENT);
		} else {

			return new ResponseEntity<List<AllocationRequest>>(allocationRequests, HttpStatus.OK);
		}
	}
}
