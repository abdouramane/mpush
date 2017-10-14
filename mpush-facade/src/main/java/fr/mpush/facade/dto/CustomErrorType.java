package fr.mpush.facade.dto;

import java.io.Serializable;

public class CustomErrorType implements Serializable {
    private String errorMessage;

    public CustomErrorType(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
