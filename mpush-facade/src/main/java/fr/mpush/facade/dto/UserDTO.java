package fr.mpush.facade.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDTO extends PersonDTO {

    private String login;
    private String password;
    private String role;
    private List<ContactDTO> contacts;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<ContactDTO> getContacts() {
        if(contacts == null) {
            contacts = new ArrayList<ContactDTO>();
        }

        return contacts;
    }

    public void setContacts(List<ContactDTO> contacts) {
        this.contacts = contacts;
    }
}
