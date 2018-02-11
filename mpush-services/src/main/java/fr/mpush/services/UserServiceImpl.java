package fr.mpush.services;

import fr.mpush.entities.User;
import fr.mpush.facade.UserService;
import fr.mpush.facade.dto.UserDTO;
import fr.mpush.mapper.UserMapper;
import fr.mpush.respository.ContactRepository;
import fr.mpush.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "customerService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO getUserByLogin(String login) {
        return userMapper.asUserDTO(userRepository.findByLogin(login));
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userMapper.asUserDTO(userRepository.findOne(id));
    }

    @Override
    public List<UserDTO> listAllUsers() {
        return userMapper.asUserDTOList(userRepository.findAll());
    }

    @Override
    public UserDTO insertOrUpdateUser(UserDTO userDTO) {
        return userMapper.asUserDTO(userRepository.save(new User(userDTO)));
    }

    @Override
    public void deleteUserContacts(Long userId, List<Long> contactsId) {
        contactRepository.deleteContacts(contactsId);
    }
}
