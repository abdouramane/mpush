package fr.mpush.facade.dto;

import java.io.Serializable;
import java.util.List;

public class ContactRequest implements Serializable {

    private List<Long> contactsId;

    public List<Long> getContactsId() {
        return contactsId;
    }

    public void setContactsId(List<Long> contactsId) {
        this.contactsId = contactsId;
    }
}
