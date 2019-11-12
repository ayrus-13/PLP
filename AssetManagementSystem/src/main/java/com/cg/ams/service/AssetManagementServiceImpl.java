package com.cg.ams.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ams.AssetManagementSystemApplication;
import com.cg.ams.dto.AllocationRequest;
import com.cg.ams.dto.Assets;
import com.cg.ams.dto.User;
import com.cg.ams.exception.AmsException;

import com.cg.ams.repository.AllocationRequestRepository;
import com.cg.ams.repository.AssetRepository;
import com.cg.ams.repository.EmployeeRepository;
import com.cg.ams.repository.UserRepository;


@Service
@Transactional
public class AssetManagementServiceImpl implements AssetManagementService {
	
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AssetRepository assetRepository;
	
	@Autowired
	AllocationRequestRepository allocationRequestRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(AssetManagementSystemApplication.class);


	@Override
	public Assets addAsset(Assets asset) {
		return assetRepository.save(asset);
	}

	@Override
	public Assets viewAssets(Integer assetId) throws AmsException {
		if(assetId==null) {
			throw new AmsException("Enter AssetId");
		}
		Assets asset=assetRepository.getOne(assetId);
		if(asset==null) {
			throw new AmsException("Asset does not exist");
		}
		else
		return asset;
	}

	@Override
	public List<Assets> viewAssets() {
		return assetRepository.findAll();
	}

	@Override
	public Assets modifyAsset(Assets asset) throws AmsException{
		Assets updateAsset=assetRepository.findByAssetId(asset.getAssetId());
		if(updateAsset==null) {
			throw new AmsException("Asset does not exist");
		}
		else {
			updateAsset.setAssetName(asset.getAssetName());
			updateAsset.setQuantity(asset.getQuantity());
		}
		return updateAsset;
	}

	@Override
	public boolean deleteAsset(Integer assetId) throws AmsException {
		if(assetId==null)
			throw new AmsException("Enter AssetId");
		Assets asset=assetRepository.getOne(assetId);
		assetRepository.deleteById(assetId);
		return false;
	}
	
	

	@Override
	public List<AllocationRequest> searchAllocationByStatus(String status) {
		List<AllocationRequest> allocationList=allocationRequestRepository.findByStatus(status);
		return allocationList;
	}

	@Override
	public List<AllocationRequest> viewAllocation() {
		return allocationRequestRepository.findAll();
	}

	@Override
	public List<AllocationRequest> getRequestsToApprove() {
		List<AllocationRequest> requests = allocationRequestRepository.findAll();
		List<AllocationRequest> pendingRequests = new ArrayList<AllocationRequest>();
		for (int i = 0; i < requests.size(); i++) {
			if (requests.get(i).getStatus().equalsIgnoreCase("Pending")) {
				pendingRequests.add(requests.get(i));
			}
		}
		if (pendingRequests != null) {
			return pendingRequests;
		}
		return null;
	}

	@Override
	public AllocationRequest checkAllocationStatus(Integer allocationId) throws AmsException {
		AllocationRequest allocationRequest = allocationRequestRepository.findById(allocationId).get();
		if (allocationRequest != null) {
			return allocationRequest;
		} else {
			throw new AmsException("Enter AllocationId");
		}
	}

	@Override
	public AllocationRequest approveAllocationRequest(Integer allocationId) throws AmsException {
		LocalDate today = LocalDate.now();
		AllocationRequest allocationRequest = allocationRequestRepository.findById(allocationId).get();
		allocationRequest.setStatus("Approved");
		return allocationRequest;
	}

	@Override
	public AllocationRequest rejectAllocationRequest(Integer allocationId) throws AmsException {
		AllocationRequest allocationRequest = allocationRequestRepository.findById(allocationId).get();
		allocationRequest.setStatus("Rejected");
		return allocationRequest;
	}

	
	@Override
	public List<AllocationRequest> viewRequests() {
		// TODO Auto-generated method stub
		return allocationRequestRepository.findAll();
	}
	

}
