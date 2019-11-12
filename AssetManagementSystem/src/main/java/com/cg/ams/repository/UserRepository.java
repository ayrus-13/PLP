package com.cg.ams.repository;


/**
* @author: SURYA
* description: User Repository
* created date: 04/11/2019
*/



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ams.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	public User findByUserId(Integer userId);
	public User findByUserName(String userName);
}
	