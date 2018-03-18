package fr.mpush.facade;

import fr.mpush.facade.dto.UserDTO;

import java.util.List;

public interface UserService {

    /**
     * Get an user by his login
     * @param login the user's login
     * @return the user
     */
    UserDTO getUserByLogin(String login);

    /**
     * Get active user by id
     * @param id id user
     * @return the user if found null if not
     */
    UserDTO getUserById(Long id);

    /**
     * Get all active users
     * @return active users
     */
    List<UserDTO> listAllUsers();

    UserDTO insertOrUpdateUser(UserDTO userDTO);

    void deactiveUserContacts(Long userId, List<Long> contactsId);

}
