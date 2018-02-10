package fr.mpush.entities;

import fr.mpush.facade.dto.ContactDTO;
import fr.mpush.facade.dto.UserDTO;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * User entity
 *
 * @author aboudou.
 */

@Entity
@Table(name = "t_user")
@DiscriminatorValue(value = "User")
public class User extends Person {

    @Column(name = "USER_LOGIN")
    private String login;

    @Column(name = "USER_PASSWORD")
    private String password;

    @Column(name = "USER_ROLE")
    private String role;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "t_user_contact",
            joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CONTACT_ID", unique = false)},
            uniqueConstraints = @UniqueConstraint(name = "uniqueUserIdContactId",
                    columnNames = {"USER_ID", "CONTACT_ID"}))
    private Collection<Contact> contacts;

    public User(){
        super();
    }

    public User(Long id, String login, String password, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(UserDTO userDTO) {
        this(userDTO.getId(), userDTO.getLogin(), userDTO.getPassword(), userDTO.getRole());
        updateContacts(userDTO);
    }

    @Column(name = "USER_ID")
    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public Collection<Contact> getContacts() {
        return contacts;
    }

    private User updateContacts(UserDTO userDTO) {
        if(CollectionUtils.isEmpty(userDTO.getContacts())){
            return this;
        }

        this.contacts = new ArrayList<Contact>();

        for(ContactDTO contactDTO : userDTO.getContacts()) {
            this.contacts.add(new Contact(contactDTO));
        }

        return this;
    }
}
