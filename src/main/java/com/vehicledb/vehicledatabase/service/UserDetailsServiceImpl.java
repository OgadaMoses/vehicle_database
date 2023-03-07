package com.vehicledb.vehicledatabase.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vehicledb.vehicledatabase.domain.User;
import com.vehicledb.vehicledatabase.domain.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepository repository;
	
	@Override
public UserDetails loadUserByUsername (String username)	
  throws UsernameNotFoundException {
		Optional<User> user = repository.findByUsername(username);
		UserBuilder builder = null;
		if (user.isPresent ()) {
			User currentUser = user.get();
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(currentUser.getPassword());
			builder.roles(currentUser.getRole().toString());
		}
		else {
			throw new UsernameNotFoundException ("User not Found");
		}
		return builder.build();
	}

}
