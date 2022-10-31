package com.cognizant.target.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.target.model.TargetDetails;
import com.cognizant.target.repo.TargetDetailsRepo;

@Service
public class TargetServiceImpl {
	
	
	@Autowired
	private TargetDetailsRepo targetRepo;

	
	public String setTarget(TargetDetails target) {
		if(targetRepo.findByUserName(target.getUserName())==null) {
			targetRepo.save(target);
			return "Target is set successfully";
			
		}
		return "Target is already set";
	}


	public TargetDetails getTarget(String username) {
		TargetDetails targetDetails=new TargetDetails(0,"",0);
		if(targetRepo.findByUserName(username)!=null) {
			return targetRepo.findAmountByUserName(username);
		}
		return targetDetails;
	}
	
	public String updateTarget(TargetDetails target) {
		if(targetRepo.findByUserName(target.getUserName())!=null) {
			
			int result=targetRepo.updateTargetAmount(target.getAmount(),target.getUserName());
			return "Target is updated successfully";
			
		}
		return "Target cannot be updated, not set yet.";
	}

		

	

}
