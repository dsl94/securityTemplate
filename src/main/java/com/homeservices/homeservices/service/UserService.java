package com.homeservices.homeservices.service;

import java.util.List;
import com.homeservices.homeservices.error.UserException;
import com.homeservices.homeservices.rest.dto.user.*;

/**
 * Created by nemanja on 9/30/2017.
 */
public interface UserService {

    UserResponseDTO register(UserRequestDTO request) throws UserException;

    List<UserSearchResponseDTO> search(String city);
}
