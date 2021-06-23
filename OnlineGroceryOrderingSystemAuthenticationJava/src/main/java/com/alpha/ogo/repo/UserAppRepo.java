package com.alpha.ogo.repo;

import com.alpha.ogo.domain.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * @author Tharindu
 *
 * Jan 19, 2021
 */
@Repository
public interface UserAppRepo extends JpaRepository<UserApp, Long>{

	@Query("FROM UserApp WHERE userId = :usserId")
	UserApp getUserAppByUserId(Long usserId);

}
