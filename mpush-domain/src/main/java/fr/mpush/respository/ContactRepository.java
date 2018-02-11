package fr.mpush.respository;

import fr.mpush.entities.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {

    //Re-ecrire la requête pour prendre en compte l'id de l'user
    @Query("delete from Contact c where c.id in ?1")
    void deleteContacts(List<Long> contactsId);

}
