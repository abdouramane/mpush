package fr.mpush.entities;

import fr.mpush.facade.dto.ContactDTO;

import javax.persistence.*;

/**
 * Class entity for a Person
 *
 * @author abdourhamane
 */
@Entity
@Table(name = "t_person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="DISCRIMINATOR",
        discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue(value = "Person")
public abstract class Person extends AbstractDatabaseEntity {

    @Id
    @Column(name = "PERSON_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    /**
     * Person first name
     */
    @Column(name = "PERSON_FIRSTNAME")
    protected String firstName;

    /**
     * Person last name
     */
    @Column(name = "PERSON_LASTNAME")
    protected String lastName;

    /**
     * Person email
     */
    @Column(name = "PERSON_EMAIL")
    protected String email;

    /**
     * Person address
     */
    @Column(name = "PERSON_ADRESS")
    protected String address;

    /**
     * Person telephone
     */
    @Column(name = "PERSON_PHONE_NUMBER")
    protected String phoneNumber;

    /**
     * Boolean true => this person is active else not
     */
    @Column(name = "PERSONE_ACTIVE")
    protected Boolean active = true;

    /**
     * Default constructor
     */
    public Person() {
        super();
    }

    /**
     * Constructor with contact name
     *
     * @param firstName the contact's name
     */
    public Person(String firstName) {
        this();
        this.firstName = firstName;
    }

    /**
     * Constructor with contact name and email
     *
     * @param firstName the contact's name
     * @param email the contact's email
     */
    public Person(String firstName, String email) {
        this(firstName);
        this.email = email;
    }

    /**
     * Constructor with contactDTO
     *
     * @param contact the contact's dto
     *
     */
    public Person(ContactDTO contact) {
        this(contact.getFirstName(), contact.getEmail());
        this.id = contact.getId();
    }

    public void deactive(Long id) {
        this.active = false;
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

    public Boolean isActive() {
        return active;
    }
}
