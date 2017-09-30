package com.homeservices.homeservices.rest.dto;

import com.homeservices.homeservices.error.ErrorMessage;
import com.homeservices.homeservices.error.UserException;
import com.homeservices.homeservices.rest.dto.user.UserRequestDTO;
import com.homeservices.homeservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.awt.*;

/**
 * Created by nemanja on 9/30/2017.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity registerUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {

        try {
            return ResponseEntity.ok().body(userService.register(userRequestDTO));
        } catch (UserException e) {
            return ResponseEntity.badRequest().body(new ErrorMessage(e.getErrorCode(), e.getErrorMessage()));
        }
    }
}
