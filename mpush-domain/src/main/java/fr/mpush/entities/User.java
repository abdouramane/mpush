package fr.mpush.entities;

import javax.persistence.*;
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

    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
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
}
