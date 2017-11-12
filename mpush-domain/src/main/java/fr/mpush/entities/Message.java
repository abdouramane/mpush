package fr.mpush.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Message entity class
 *
 * @author aboudou
 */

@Entity
@Table(name = "t_message")
public class Message extends AbstractDatabaseEntity {

    /**
     * Serial number for serialisation/deserialisation
     */
    private static final long serialVersionUID=1L;

    /**
     * Idenifier of the message
     */
    @Column(name = "MESSAGE_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    /**
     * Store the message content
     */
    @Column(name="MESSAGE_CONTENT")
    private String content;

    /**
     * Set if the message is a draft or not
     */
    @Column(name = "MESSAGE_IS_DRAFT")
    private Boolean draft;

    /**
     * Store the message title
     */
    @Column(name = "MESSAGE_TITLE")
    private String title;

    /**
     * Datetime at which the message has been sended
     */
    @Column(name = "MESSAGE_DATE_SENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSent;

    /**
     * Message receivers
     */
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_message_receiver",
    joinColumns = {@JoinColumn(name = "MESSAGE_ID")},
    inverseJoinColumns = {@JoinColumn(name = "CUSTOMER_ID")})
    private Set<Person> receivers;

    /**
     * Message sender
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SENDER_ID")
    private Person sender;

    public Message(String content, Boolean draft, String title, Date dateSent) {
        this.content = content;
        this.draft = draft;
        this.title = title;
        this.dateSent = dateSent;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Boolean getDraft() {
        return draft;
    }

    public String getTitle() {
        return title;
    }

    public Date getDateSent() {
        return dateSent;
    }

    public Set<Person> getReceivers() {
        return receivers;
    }

    public Person getSender() {
        return sender;
    }
}
