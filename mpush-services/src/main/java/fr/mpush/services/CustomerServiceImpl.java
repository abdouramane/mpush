package fr.mpush.services;

import fr.mpush.facade.CustomerService;
import fr.mpush.facade.dto.CustomerDTO;
import fr.mpush.mapper.CustomerMapper;
import fr.mpush.respository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public CustomerDTO getCustomerByEmail(String email) {
        return customerMapper.asCustomerDTO(customerRepository.findByEmail(email));
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerMapper.asCustomerDTO(customerRepository.findOne(id));
    }

    @Override
    public List<CustomerDTO> listAllCustomers() {
        return customerMapper.asCustomerDTOList(customerRepository.findAll());
    }

}
