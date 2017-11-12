package fr.mpush.facade;

import fr.mpush.facade.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO getUserByLogin(String login);

    UserDTO getUserById(Long id);

    List<UserDTO> listAllUsers();
}
