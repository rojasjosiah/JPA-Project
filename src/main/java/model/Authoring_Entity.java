package csulb.cecs323.model;

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

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "AUTHORING_ENTITY_NAME")
    @Column (length=80, nullable = false)
    private String name;

    @Column (length=80)
    private String head_writer;

    @Column
    private int year_formed;
}
