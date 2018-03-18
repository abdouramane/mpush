package fr.mpush.controller;

import fr.mpush.facade.UserService;
import fr.mpush.facade.dto.ContactDTO;
import fr.mpush.facade.dto.CustomErrorType;
import fr.mpush.facade.dto.LoginForm;
import fr.mpush.facade.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.function.Predicate;

/**
 * Login controller
 *
 * @author abdourhamane
 */
@RestController
@RequestMapping("/mpush")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginForm loginForm) {
        final UserDTO user = userService.getUserByLogin(loginForm.getLogin());

        if(user == null) {
            logger.error("Identifiant ou mot passe erroné");
            return new ResponseEntity<>(new CustomErrorType("Identifiant ou mot passe erroné"),
                    HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(user.getId());
    }

}
