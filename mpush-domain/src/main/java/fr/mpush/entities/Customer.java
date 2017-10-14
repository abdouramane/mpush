package fr.mpush.entities;

import fr.mpush.facade.dto.CustomerDTO;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class entity for a Customer
 * @author abdourhamane
 */
@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String email;

    /**
     * Default constructor
     */
    public Customer() {
        super();
    }

    /**
     * Constructor with customer name
     *
     * @param firstName the customer's name
     */
    public Customer(String firstName) {
        this();
        this.firstName = firstName;
    }

    /**
     * Constructor with customer name and email
     *
     * @param firstName the customer's name
     * @param email the customer's email
     */
    public Customer(String firstName, String email) {
        this(firstName);
        this.email = email;
    }

    /**
     * Constructor with customerDTO
     *
     * @param customer the customer's dto
     *
     */
    public Customer(CustomerDTO customer) {
        this(customer.getFirstName(), customer.getEmail());
        this.id = customer.getId();
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }
}
