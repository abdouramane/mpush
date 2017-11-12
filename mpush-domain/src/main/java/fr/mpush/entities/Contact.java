package fr.mpush.entities;

import fr.mpush.facade.dto.CategoryDTO;

import javax.persistence.*;


@Entity
@Table(name = "t_contact")
@DiscriminatorValue(value = "Contact")
public class Contact extends Person {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    public Contact() {
        super();
    }

    /**
     * Default constructor
     */
    public Contact(CategoryDTO categoryDTO) {
        this.category = new Category(categoryDTO.getName());
    }

    @Column(name = "CONTACT_ID")
    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

}
