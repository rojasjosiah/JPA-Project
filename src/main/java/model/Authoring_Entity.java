package model;

import javax.persistence.*;

@Entity
public class Authoring_Entity {
    /*
    create table AUTHORING_ENTITIES (
    EMAIL VARCHAR(30) not null primary key,
    AUTHORING_ENTITY_TYPE VARCHAR(31),
    NAME VARCHAR(80) not null,
    HEAD_WRITER VARCHAR(80),
    YEAR_FORMED INTEGER
);*/
    @Id
    @Column (length=30, nullable = false)
    private String email;

    @Column (length=31)
    private String authoring_entity_type;

// I could be wrong, but this doesn't look like a one to one relationship
// it's just a normal column
//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "AUTHORING_ENTITY_NAME")
    @Column (length=80, nullable = false)
    private String name;

    @Column (length=80)
    private String head_writer;

    @Column
    private int year_formed;

    public Authoring_Entity (String email, String authoring_entity_type, String name, String head_writer, int year_formed) {
        this.setEmail(email);
        this.setAuthoring_Entity_Type(authoring_entity_type);
        this.setName(name);
        this.setHead_Writer(head_writer);
        this.setYear_Formed(year_formed);
    }

    public Authoring_Entity () {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String e) { this.email = e; }

    public String getAuthoring_Entity_Type() {
        return authoring_entity_type;
    }

    public void setAuthoring_Entity_Type(String a) { this.authoring_entity_type = a; }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getHead_Writer() {
        return head_writer;
    }

    public void setHead_Writer(String h) {
        this.head_writer = h;
    }

    public int getYear_Formed() { return year_formed; }

    public void setYear_Formed(int y) {
        this.year_formed = y;
    }

    @Override
    public String toString () {
        return "Authoring_Entity - Email: " + this.getEmail() + " Type: " + this.getAuthoring_Entity_Type() +
                " Name: " + this.getName() +
                " Head Writer: " + this.getHead_Writer() +
                " Year Formed: " + this.getYear_Formed();
    }
}

