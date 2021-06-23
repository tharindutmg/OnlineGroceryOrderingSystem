package com.alpha.ogo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alpha.ogo.domain.User;
import com.alpha.ogo.repo.UserRepo;
import com.alpha.ogo.security.MyUserDetails;


@Service
public class LoginServiceImpl implements UserDetailsService{
	
	@Autowired
    UserRepo userRepository;
	
	@Override
    public MyUserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //return new User("foo", "foo",new ArrayList<>());
		Optional<User> user = userRepository.findByPhoneNo(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        return user.map(MyUserDetails::new).get();
        
    }

}
