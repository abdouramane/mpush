package fr.mpush.facade.dto;

import java.io.Serializable;

public class LoginForm implements Serializable {
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
