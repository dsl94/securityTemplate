package com.homeservices.homeservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.homeservices.homeservices.model.Authority;

/**
 * Created by neman on 09/10/2017.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String>{
}
