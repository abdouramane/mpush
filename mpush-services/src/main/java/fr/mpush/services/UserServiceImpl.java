package fr.mpush.services;

import fr.mpush.entities.User;
import fr.mpush.facade.UserService;
import fr.mpush.facade.dto.UserDTO;
import fr.mpush.mapper.UserMapper;
import fr.mpush.respository.ContactRepository;
import fr.mpush.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        User user = userRepository.findByLoginAndActiveIsTrue(login);

        //Filter user's contacts
        if(user.getContacts() != null){
            user.getContacts().removeIf(contactDTO -> contactDTO.isActive() == null || !contactDTO.isActive());
        }

        return userMapper.asUserDTO(user);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findByIdAndActiveIsTrue(id);

        //Filter user's contacts
        if(user.getContacts() != null){
            user.getContacts().removeIf(contactDTO -> contactDTO.isActive() == null || !contactDTO.isActive());
        }

        return userMapper.asUserDTO(user);
    }

    @Override
    public List<UserDTO> listAllUsers() {
        return userMapper.asUserDTOList(userRepository.findAll());
    }

    @Override
    public UserDTO insertOrUpdateUser(UserDTO userDTO) {
        User user = userRepository.save(new User(userDTO));

        //Filter user's contacts
        if(user.getContacts() != null){
            user.getContacts().removeIf(contactDTO -> contactDTO.isActive() == null || !contactDTO.isActive());
        }

        return userMapper.asUserDTO(user);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deactiveUserContacts(Long userId, List<Long> contactsId) {
        contactRepository.deactiveUserContacts(contactsId);
    }
}
