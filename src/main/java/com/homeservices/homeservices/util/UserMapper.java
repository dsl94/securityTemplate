package com.homeservices.homeservices.util;

import java.util.*;
import java.util.stream.Collectors;
import com.homeservices.homeservices.model.Authority;
import com.homeservices.homeservices.model.User;
import com.homeservices.homeservices.rest.dto.user.*;
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

    public List<UserSearchResponseDTO> mapSearchResponses(List<User> users) {

        return users.stream().map(user -> new UserSearchResponseDTO(
            user.getUsername(),
            user.getFirstName(),
            user.getLastName(),
            user.getCity(),
            user.getPricePerHour())).collect(Collectors.toList());
    }
}
