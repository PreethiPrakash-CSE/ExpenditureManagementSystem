package com.cognizant.target.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.target.model.TargetDetails;

@Repository
public interface TargetDetailsRepo extends JpaRepository<TargetDetails,Integer>{

	TargetDetails findAmountByUserName(String username);

	TargetDetails findByUserName(String username);
	
	@Transactional
	@Modifying
    @Query(value="UPDATE target t SET t.amount = ?1 WHERE t.username = ?2", nativeQuery=true)
    int updateTargetAmount(int amount,String username);
	
	
	

}

