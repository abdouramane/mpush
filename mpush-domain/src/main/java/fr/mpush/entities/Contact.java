package fr.mpush.entities;

import fr.mpush.facade.dto.CategoryDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Table(name = "t_contact")
@DiscriminatorValue(value = "Contact")
public class Contact extends Person {

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Category> categories;

    public Contact() {
        super();
        this.categories = new ArrayList<Category>();
    }

    /**
     * Default constructor
     */
    public Contact(CategoryDTO categoryDTO) {
        this();
        this.categories.add(new Category(categoryDTO.getName()));
    }

    @Column(name = "CONTACT_ID")
    public Long getId() {
        return id;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

}
