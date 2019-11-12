package com.cg.ams.service;


import java.util.List;


import com.cg.ams.dto.AllocationRequest;
import com.cg.ams.dto.Assets;
import com.cg.ams.dto.User;
import com.cg.ams.exception.AmsException;


public interface AssetManagementService {
	
	//public AssetStatus approveRequest(Integer allocationId);
	
	//public User getUser(Integer userId) throws AmsException;
	
	//public User getUser(String userName);

	public Assets addAsset(Assets asset);
    
	public Assets viewAssets(Integer assetId) throws AmsException;
    
	public List<Assets> viewAssets();
    
	public Assets modifyAsset(Assets asset) throws AmsException;
    
	public boolean deleteAsset(Integer assetId) throws AmsException;
	
	public List<AllocationRequest> searchAllocationByStatus(String status);
	
	public List<AllocationRequest> viewAllocation();

	public AllocationRequest approveAllocationRequest(Integer allocationId) throws AmsException;
	
	public AllocationRequest rejectAllocationRequest(Integer allocationId) throws AmsException;
	
	public List<AllocationRequest> getRequestsToApprove();
	
	public AllocationRequest checkAllocationStatus(Integer allocationId) throws AmsException;
	
	public List<AllocationRequest> viewRequests();
	
	
}
