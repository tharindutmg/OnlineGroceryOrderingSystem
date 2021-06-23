package com.alpha.ogo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alpha.ogo.domain.Address;

import java.util.List;

/**
 * @author Tharindu
 *
 * @Date Jun 18, 2021
 *
 */
@Repository
public interface AddressRepo extends JpaRepository<Address, Long>{

	List<Address> getAddressByUserId(Long userId);

}
