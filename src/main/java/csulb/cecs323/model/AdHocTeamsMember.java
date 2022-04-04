package csulb.cecs323.model;

import javax.persistence.*;

@Entity
public class AdHocTeamsMember {
    /*
    create table AD_HOC_TEAMS_MEMBER (
    INDIVIDUAL_AUTHORS_EMAIL VARCHAR(30) not null
        constraint DHCTMSMNDVDLTHRSML
            references AUTHORING_ENTITIES,
    AD_HOC_TEAMS_EMAIL VARCHAR(30) not null
        constraint DHCTMSMMBRDHCTMSML
            references AUTHORING_ENTITIES,
    primary key (INDIVIDUAL_AUTHORS_EMAIL, AD_HOC_TEAMS_EMAIL)
);*/

    // Need to figure out reference constraints

    @Id // FIXME: Wrong, need PK class, added this to remove error
    @Column (length=30, nullable = false)
    private String individual_authors_email;

    @Column (length=30, nullable = false)
    private String ad_hoc_teams_email;
}
