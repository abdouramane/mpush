package fr.mpush.controller;

import fr.mpush.facade.UserService;
import fr.mpush.facade.dto.CustomErrorType;
import fr.mpush.facade.dto.ContactDTO;
import fr.mpush.facade.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest API Controller for the mPush App
 *
 * @author abdourhamane
 */
@RestController
@RequestMapping("/mpush/api")
public class RestApiController {

    private static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);

        if(user == null) {
            logger.error("User with id {} not found.", id);
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("User with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<?> listAllUsers() {
        List<UserDTO> users = userService.listAllUsers();

        if(CollectionUtils.isEmpty(users)) {
            logger.error("No user found.");
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("No user found."), HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(users);
    }

    @PutMapping("/users")
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
