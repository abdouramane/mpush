package fr.mpush.entities;

import javax.persistence.*;

/**
 * User entity
 *
 * @author aboudou.
 */

@Entity
@Table(name = "t_user")
@DiscriminatorValue(value = "User")
public class User extends Customer {

    @Column(name = "USER_LOGIN")
    private String login;

    @Column(name = "USER_PASSWORD")
    private String password;

    @Column(name = "USER_ROLE")
    private String role;

    public User(){
        super();
    }

    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
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
}
