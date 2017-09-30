package com.homeservices.homeservices.service.impl;

import com.homeservices.homeservices.error.ErrorCode;
import com.homeservices.homeservices.error.UserException;
import com.homeservices.homeservices.model.User;
import com.homeservices.homeservices.repository.UserRepository;
import com.homeservices.homeservices.rest.dto.user.UserRequestDTO;
import com.homeservices.homeservices.rest.dto.user.UserResponseDTO;
import com.homeservices.homeservices.service.UserService;
import com.homeservices.homeservices.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nemanja on 9/30/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserResponseDTO register(UserRequestDTO request) throws UserException {

        if (userRepository.findByUsernameIgnoreCase(request.getUsername()) != null) {
            throw new UserException(ErrorCode.USERNAME_EXIST, "User with that username already exist");
        }

        if (userRepository.findByEmailIgnoreCase(request.getEmail()) != null) {
            throw new UserException(ErrorCode.EMAIL_EXIST, "User with that email already exist");
        }

        User forSave = userMapper.mapFromRequest(request);
        User result = userRepository.save(forSave);

        return userMapper.mapResponseFromEntity(result);
    }
}
