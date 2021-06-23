package com.alpha.ogo.repo;

import com.alpha.ogo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * @author Tharindu
 *
 * Jan 4, 2021
 */
@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{

	@Query("FROM Role WHERE roleCode=:roleCode")
	Role getrolebyRoleCode(String roleCode);

}
