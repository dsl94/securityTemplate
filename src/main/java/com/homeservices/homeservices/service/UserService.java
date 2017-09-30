package com.homeservices.homeservices.service;

import com.homeservices.homeservices.error.UserException;
import com.homeservices.homeservices.rest.dto.user.UserRequestDTO;
import com.homeservices.homeservices.rest.dto.user.UserResponseDTO;

/**
 * Created by nemanja on 9/30/2017.
 */
public interface UserService {

    UserResponseDTO register(UserRequestDTO request) throws UserException;
}
