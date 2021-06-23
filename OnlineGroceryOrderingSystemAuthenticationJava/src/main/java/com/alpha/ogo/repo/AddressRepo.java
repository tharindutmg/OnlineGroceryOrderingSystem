package com.alpha.ogo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.ogo.domain.Address;

/**
 * @author Tharindu
 *
 * @Date Jun 18, 2021
 *
 */
@Repository
public interface AddressRepo extends JpaRepository<Address, Long>{

	Address getAddressByUserId(Long userId);

}
