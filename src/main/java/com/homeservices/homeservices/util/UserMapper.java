package com.homeservices.homeservices.util;

import com.homeservices.homeservices.model.User;
import com.homeservices.homeservices.rest.dto.user.UserRequestDTO;
import com.homeservices.homeservices.rest.dto.user.UserResponseDTO;
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
        user.setUserType(request.getUserType());
        user.setPricePerHour(request.getPricePerHour());

        return user;
    }

    public UserResponseDTO mapResponseFromEntity(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setUsername(user.getUsername());

        return userResponseDTO;
    }
}
