package fr.mpush.entities;

import javax.persistence.*;

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

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
