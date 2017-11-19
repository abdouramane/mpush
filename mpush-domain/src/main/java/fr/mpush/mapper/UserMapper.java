package fr.mpush.mapper;

import fr.mpush.entities.User;
import fr.mpush.facade.dto.UserDTO;
import fr.xebia.extras.selma.CollectionMappingStrategy;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

import java.util.List;

@Mapper(withIoC = IoC.SPRING, withIgnoreFields = {"UserDTO.password"},
        withIgnoreMissing = IgnoreMissing.DESTINATION,
        withCollectionStrategy = CollectionMappingStrategy.ALLOW_GETTER)
public interface UserMapper {

    UserDTO asUserDTO(User in);

    List<UserDTO> asUserDTOList(List<User> in);
}
