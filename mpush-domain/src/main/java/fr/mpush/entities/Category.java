package fr.mpush.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Class for Category bean
 *
 * @author aboudou.
 */

@Entity
@Table(name = "t_category")
public class Category extends AbstractDatabaseEntity {

    @Column(name = "CATEGORY_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "CATEGORY_NAME")
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Collection<Contact> contacts;

    public Category() {
        super();
        this.contacts = new ArrayList<Contact>();
    }

    public Category(String name) {
        this();
        this.name = name;
    }

    public Category(Long id, String name) {
        this(name);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Contact> getContacts() {
        return contacts;
    }
}
