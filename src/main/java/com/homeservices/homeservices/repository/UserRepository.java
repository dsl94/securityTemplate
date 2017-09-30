package com.homeservices.homeservices.repository;

import com.homeservices.homeservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nemanja on 9/30/2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameIgnoreCase(String username);

    User findByEmailIgnoreCase(String email);
}
