package fr.mpush.controller;

import fr.mpush.facade.UserService;
import fr.mpush.facade.dto.CustomErrorType;
import fr.mpush.facade.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller handling registration process
 *
 * @author sareaboudousamadou.
 */

@RestController
@RequestMapping("/mpush/register")
public class RegisterController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> registerNewUser(@RequestBody UserDTO userDTO) {
        logger.info("Creating new User");

        //check if the user already exists
        if(userDTO == null) {
            logger.error("A user must be provided");
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("You must provide a user"), HttpStatus.NO_CONTENT);
        }

        //verify if the user already exists
        if(userService.getUserByLogin(userDTO.getLogin()) != null) {
            logger.error("User already exists");
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("USER_ALREADY_EXISTS"), HttpStatus.CONFLICT);
        }

        //Create a new user
        userService.insertUser(userDTO);
        //TODO : send an email to verify user email address
        return new ResponseEntity<String>("User successfully created", HttpStatus.CREATED);

    }
}
