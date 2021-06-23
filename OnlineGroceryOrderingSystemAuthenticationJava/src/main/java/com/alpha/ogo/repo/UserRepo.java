package com.alpha.ogo.repo;

import java.util.Optional;

import com.alpha.ogo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * @author Tharindu
 *
 * Dec 30, 2020
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	
	Optional<User> findByPhoneNo(String phoneNo);
	
	@Query("FROM User WHERE phoneNo = :phoneNo")
	User getByUserName(String phoneNo);

	User getUserByPhoneNo(String phoneNo);
	
	/*
	 * @Query("SELECT vam_user_seq.Nextval from dual") Long getNextVal();
	 */

}
