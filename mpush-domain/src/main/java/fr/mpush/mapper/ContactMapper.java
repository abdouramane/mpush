package fr.mpush.mapper;

import fr.mpush.entities.Contact;
import fr.mpush.entities.Person;
import fr.mpush.facade.dto.ContactDTO;
import fr.xebia.extras.selma.*;

import java.util.List;

@Mapper(withIoC = IoC.SPRING,  withIgnoreMissing = IgnoreMissing.DESTINATION,
        withCollectionStrategy = CollectionMappingStrategy.ALLOW_GETTER)
public interface ContactMapper {

    ContactDTO asContactDTO(Contact in);

    List<ContactDTO> asContactDTOList(List<Contact> in);

}
