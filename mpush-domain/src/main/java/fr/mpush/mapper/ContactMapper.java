package fr.mpush.mapper;

import fr.mpush.entities.Contact;
import fr.mpush.entities.Person;
import fr.mpush.facade.dto.ContactDTO;
import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

import java.util.List;

@Mapper(withIoC = IoC.SPRING, withCustomFields = {@Field(value = "category", withCustom = CategoryMapper.class)})
public interface ContactMapper {

    ContactDTO asCustomerDTO(Contact in);

    List<ContactDTO> asCustomerDTOList(List<Contact> in);

}
