package fr.mpush.respository;

import fr.mpush.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Person repository
 *
 * @author abdourhamane
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

    List<User> findAll();

}
