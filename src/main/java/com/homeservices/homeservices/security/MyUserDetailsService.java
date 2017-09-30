package com.homeservices.homeservices.security;

import com.homeservices.homeservices.model.User;
import com.homeservices.homeservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by nemanja on 9/30/2017.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameIgnoreCase(s);
        if (user == null) {
            throw new UsernameNotFoundException(s);
        }

        return new MyUserPrincipal(user);
    }
}
