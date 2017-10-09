package com.homeservices.homeservices.rest.dto;

import com.homeservices.homeservices.error.ErrorMessage;
import com.homeservices.homeservices.error.UserException;
import com.homeservices.homeservices.rest.dto.user.UserRequestDTO;
import com.homeservices.homeservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * THESE NEXT REST CALLS ARE USED TO TES ROLE, DELETE THEM AFTER TESTING IS DONE
     */
    @RequestMapping(value = "/empl", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity testEmployer() {
        return ResponseEntity.ok("SVE JE OK, EMPLOYER PRIJAVLJEN");
    }

    @RequestMapping(value = "/work", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity testWorker() {
        return ResponseEntity.ok("SVE JE OK, WORKER PRIJAVLJEN");
    }
}
