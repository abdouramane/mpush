package fr.mpush.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Class containing common element of Database bean
 *
 * @author aboudou.
 */

@MappedSuperclass
public abstract class AbstractDatabaseEntity implements Serializable {

    /**
     * Serial number for serialisation/deserialisation
     */
    private static final long serialVersionUID=1L;


    /**
     * Creation date of current entity
     */
    @Column(name="CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    /**
     * Modification date of entity field
     */
    @Column(name="MODIFIED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    public Date getCreated() {
        return created;
    }

    public Date getModified() {
        return modified;
    }
}
