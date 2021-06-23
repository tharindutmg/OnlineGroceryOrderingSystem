package com.alpha.ogo.repo;

import com.alpha.ogo.domain.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * @author Tharindu
 *
 * Dec 28, 2020
 */
@Repository
public interface RegistrationRepo extends JpaRepository<Registration, Long>{
	Registration getRegistrationByNic(String nic);
}
