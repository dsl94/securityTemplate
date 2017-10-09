package com.homeservices.homeservices.repository;

import java.util.List;
import com.homeservices.homeservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by nemanja on 9/30/2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameIgnoreCase(String username);

    User findByEmailIgnoreCase(String email);

    @Query("SELECT u FROM User u WHERE upper(u.city) like %?1%")
    List<User> findByCityIgnoreCase(String query);
}
