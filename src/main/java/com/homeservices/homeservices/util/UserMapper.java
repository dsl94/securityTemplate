package com.homeservices.homeservices.util;

import java.util.HashSet;
import java.util.Set;
import com.homeservices.homeservices.model.Authority;
import com.homeservices.homeservices.model.User;
import com.homeservices.homeservices.rest.dto.user.UserRequestDTO;
import com.homeservices.homeservices.rest.dto.user.UserResponseDTO;
import com.homeservices.homeservices.security.AuthoritiesConstants;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by nemanja on 9/30/2017.
 */
@Component
public class UserMapper {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User mapFromRequest(UserRequestDTO request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setCity(request.getCity());
        Set<Authority> authorities = new HashSet<>();
        if (request.getPricePerHour() != null) {
            Authority authority = new Authority();
            authority.setName(AuthoritiesConstants.WORKER);
            authorities.add(authority);
            user.setAuthorities(authorities);
            user.setPricePerHour(request.getPricePerHour());
        } else {
            Authority authority = new Authority();
            authority.setName(AuthoritiesConstants.EMPLOYER);
            authorities.add(authority);
            user.setAuthorities(authorities);
        }

        return user;
    }

    public UserResponseDTO mapResponseFromEntity(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setUsername(user.getUsername());

        return userResponseDTO;
    }
}
