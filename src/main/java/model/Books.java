package model;

import javax.persistence.*;

/**create table BOOKS
(
    ISBN VARCHAR(17) not null
        primary key,
    TITLE VARCHAR(80) not null,
    YEAR_PUBLISHED INTEGER not null,
    AUTHORING_ENTITY_NAME VARCHAR(30)
        constraint BKSTHRNGENTITYNAME
            references AUTHORING_ENTITIES,
    PUBLISHER_NAME VARCHAR(80)
        constraint BOOKSPUBLISHERNAME
            references PUBLISHERS,
    unique (TITLE, PUBLISHER_NAME),
    unique (TITLE, AUTHORING_ENTITY_NAME)
);**/

@Entity

@Table(uniqueConstraints = {@UniqueConstraint(columnNames =
        {"TITLE", "PUBLISHER_NAME"}), @UniqueConstraint(columnNames =
        {"TITLE", "AUTHORING_ENTITY_NAME"})})
public class Books {
    @Id
    @Column(length = 17, nullable = false)
    private String ISBN;

    @Column(length = 80, nullable = false)
    private String TITLE;

    @Column(nullable = false)
    private int YEAR_PUBLISHED;

    //@JoinColumn(name = "BKSTHRNGENTITYNAME", referencedColumnName = "name")
    @OneToMany(fetch = FetchType.LAZY)
    @Column(length = 30)
    private String AUTHORING_ENTITY_NAME;

    @Column(length = 80)
    private String PUBLISHER_NAME;

    public Books(String ISBN, String TITLE, int YEAR_PUBLISHED, String AUTHORING_ENTITY_NAME,
                 String PUBLISHER_NAME){
        this.ISBN = ISBN;
        this.TITLE = TITLE;
        this.YEAR_PUBLISHED = YEAR_PUBLISHED;
        this.AUTHORING_ENTITY_NAME = AUTHORING_ENTITY_NAME;
        this.PUBLISHER_NAME = PUBLISHER_NAME;
    }

    public Books() {}

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public void setYEAR_PUBLISHED(Integer YEAR_PUBLISHED) {
        this.YEAR_PUBLISHED = YEAR_PUBLISHED;
    }

    public void setAUTHORING_ENTITY_NAME(String AUTHORING_ENTITY_NAME) {
        this.AUTHORING_ENTITY_NAME = AUTHORING_ENTITY_NAME;
    }

    public void setPUBLISHER_NAME(String PUBLISHER_NAME) {
        this.PUBLISHER_NAME = PUBLISHER_NAME;
    }

    /** for debugging **/
    @Override
    public String toString () {
        return "Book - ISBN: " + this.ISBN + " Title: " + this.TITLE +
                " Year: " + this.YEAR_PUBLISHED +
                " AUTHORING_ENTITY_NAME: " + this.AUTHORING_ENTITY_NAME +
                " PUBLISHER_NAME: " + this.PUBLISHER_NAME;
    }
}
