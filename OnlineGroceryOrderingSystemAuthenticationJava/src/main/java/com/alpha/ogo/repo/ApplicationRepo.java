package com.alpha.ogo.repo;

import java.util.List;

import com.alpha.ogo.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * @author Tharindu
 *
 * Jan 13, 2021
 */
@Repository
public interface ApplicationRepo extends JpaRepository<Application, Long>{

	@Query("FROM Application WHERE applicationCode=:applicationCode")
	Application getApplicationbyApplicationCode(String applicationCode);

	@Query("FROM Application ORDER BY sequence")
	List<Application> getAllApplications();
	
	@Query("FROM Application WHERE applicationId IN (:appIdList) ORDER BY sequence")
	List<Application> getApplicationsByApplicationIdList(@Param("appIdList") List<Long> appIdList);

}
