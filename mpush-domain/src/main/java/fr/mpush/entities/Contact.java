package fr.mpush.entities;

import fr.mpush.facade.dto.CategoryDTO;
import fr.mpush.facade.dto.ContactDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Table(name = "t_contact")
@DiscriminatorValue(value = "Contact")
public class Contact extends Person {

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Category> categories;

    /**
     * Default constructor
     */
    public Contact() {
        super();
        this.categories = new ArrayList<Category>();
    }

    public Contact(CategoryDTO categoryDTO) {
        this();
        this.categories.add(new Category(categoryDTO.getName()));
    }

    public Contact(ContactDTO contactDTO) {
        this();
        this.id = contactDTO.getId();
        this.email = contactDTO.getEmail();
        this.address = contactDTO.getAddress();
        this.firstName = contactDTO.getFirstName();
        this.lastName = contactDTO.getLastName();

    }

    @Column(name = "CONTACT_ID")
    public Long getId() {
        return id;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

}
