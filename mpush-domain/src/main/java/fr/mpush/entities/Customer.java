package fr.mpush.entities;

import fr.mpush.facade.dto.CustomerDTO;

import javax.persistence.*;
import java.util.Collection;

/**
 * Class entity for a Customer
 *
 * @author abdourhamane
 */
@Entity
@Table(name = "t_customer")
public class Customer extends AbstractDatabaseEntity {


    @Column(name = "CUSTOMER_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    /**
     * Customer first name
     */
    @Column(name = "CUSTOMER_FIRSTNAME")
    private String firstName;

    /**
     * Customer last name
     */
    @Column(name = "CUSTOMER_LASTNAME")
    private String lastName;

    /**
     * Customer email
     */
    @Column(name = "CUSTOMER_EMAIL")
    private String email;

    /**
     * Customer address
     */
    @Column(name = "CUSTOMER_ADRESS")
    private String address;

    /**
     * Customer telephone
     */
    @Column(name = "CUSTOMER_PHONE_NUMBER")
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_customer_contact",
    joinColumns = {@JoinColumn(name = "CUSTOMER_ID", unique = true)},
    inverseJoinColumns = {@JoinColumn(name = "CONTACT_ID")})
    private Collection<Customer> contact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

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

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Category getCategory() {
        return category;
    }
}
