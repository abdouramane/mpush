package fr.mpush.controller;

import fr.mpush.facade.CustomerService;
import fr.mpush.facade.dto.CustomErrorType;
import fr.mpush.facade.dto.CustomerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest API Controller for the mPush App
 *
 * @author abdourhamane
 */
@RestController
@RequestMapping("/mpush/api")
public class RestApiController {

    private static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        CustomerDTO customer = customerService.getCustomerById(id);

        if(customer == null) {
            logger.error("Customer with id {} not found.", id);
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Customer with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(customer);
    }

    @RequestMapping("/customers")
    public ResponseEntity<?> listAllCustomers() {
        List<CustomerDTO> customers = customerService.listAllCustomers();

        if(CollectionUtils.isEmpty(customers)) {
            logger.error("No customers found.");
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("No customers found."), HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(customers);
    }

}
