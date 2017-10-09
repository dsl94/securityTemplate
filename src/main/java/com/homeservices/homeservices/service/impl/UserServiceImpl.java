package com.homeservices.homeservices.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.homeservices.homeservices.error.ErrorCode;
import com.homeservices.homeservices.error.UserException;
import com.homeservices.homeservices.model.Authority;
import com.homeservices.homeservices.model.User;
import com.homeservices.homeservices.repository.UserRepository;
import com.homeservices.homeservices.rest.dto.user.*;
import com.homeservices.homeservices.security.AuthoritiesConstants;
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

	@Override
	public List<UserSearchResponseDTO> search(String city)
	{
		List<User> allUserFromThatCity = userRepository.findByCityIgnoreCase(city.toUpperCase());
		Authority authority = new Authority();
		authority.setName(AuthoritiesConstants.WORKER);
		List<User> workers = allUserFromThatCity.stream().filter(user -> user.getAuthorities().contains(authority)).collect(Collectors.toList());

		return userMapper.mapSearchResponses(workers);
	}
}
