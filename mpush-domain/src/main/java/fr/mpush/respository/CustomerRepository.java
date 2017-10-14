package fr.mpush.respository;

import fr.mpush.entities.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Customer repository
 *
 * @author abdourhamane
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByEmail(String email);

    List<Customer> findAll();

}
