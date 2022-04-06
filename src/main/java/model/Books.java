package model;

import javax.persistence.*;
import java.util.Set;

/**create table BOOKS
 (
 ISBN VARCHAR(17) not null
 primary key,
 TITLE VARCHAR(80) not null,
 YEAR_PUBLISHED INTEGER not null,
 AUTHORING_ENTITY_NAME VARCHAR(30)
 constraint BOOKSAUTHORNGENTITYNAME
 references AUTHORING_ENTITIES,
 PUBLISHER_NAME VARCHAR(80)
 constraint BOOKSPUBLISHERNAME
 references PUBLISHERS,
 unique (TITLE, PUBLISHER_NAME),
 unique (TITLE, AUTHORING_ENTITY_NAME)
 );**/

@Entity

@Table(uniqueConstraints = {@UniqueConstraint(columnNames =
        {"title", "publisher_name"}), @UniqueConstraint(columnNames =
        {"title", "authoring_entity_name"})})
public class Books {
    @Id
    @Column(length = 17, nullable = false)
    private String ISBN;

    @Column(length = 80, nullable = false)
    private String title;

    @Column(nullable = false)
    private int year_published;

    @ManyToMany
    @JoinColumn//(length = 30)
    private Set<Authoring_Entity> authoring_entity_name;

    @ManyToMany
    @JoinColumn//(length = 80)
    private Set<Publishers> publisher_name;

    public Books(String ISBN, String title, int year_published, Set<Authoring_Entity> authoring_entity_name,
                 Set<Publishers> publisher_name){
        this.ISBN = ISBN;
        this.title = title;
        this.year_published = year_published;
        this.authoring_entity_name = authoring_entity_name;
        this.publisher_name = publisher_name;
    }

    public Books() {}

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear_published(Integer year_published) {
        this.year_published = year_published;
    }

    public void setAuthoring_entity_name(Set<Authoring_Entity> authoring_entity_name) {
        this.authoring_entity_name = authoring_entity_name;
    }

    public void setPublisher_name(Set<Publishers> publisher_name) {
        this.publisher_name = publisher_name;
    }

    /** for debugging **/
    @Override
    public String toString () {
        return "Book - ISBN: " + this.ISBN + " Title: " + this.title +
                " Year: " + this.year_published +
                " AUTHORING_ENTITY_NAME: " + this.authoring_entity_name +
                " PUBLISHER_NAME: " + this.publisher_name;
    }
}

