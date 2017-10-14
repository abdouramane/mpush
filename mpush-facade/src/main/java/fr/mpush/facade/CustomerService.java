package fr.mpush.facade;

import fr.mpush.facade.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO getCustomerByEmail(String email);

    CustomerDTO getCustomerById(Long id);

    List<CustomerDTO> listAllCustomers();
}
