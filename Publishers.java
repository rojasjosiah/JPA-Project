package csulb.cecs323.model;
/** From Josiah's branch. **/

/*create table PUBLISHERS
        (
        NAME VARCHAR(80) not null
        primary key,
        EMAIL VARCHAR(80) not null
        unique,
        PHONE VARCHAR(24) not null
        unique
        );*/

import javax.persistence.*;
@Entity
public class Publishers {
    @Id
    @Column(length = 80, nullable = false)
    private String NAME;

    @Column(length = 80, nullable = false, unique = true)
    private String EMAIL;

    @Column(length = 24, nullable = false, unique = true)
    private String PHONE;

    public Publishers (String NAME, String EMAIL, String PHONE){
        this.setNAME(NAME);
        this.setEMAIL(EMAIL);
        this.setPHONE(PHONE);
    }

    public Publishers () {}

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setEMAIL(String email) {
        this.EMAIL = email;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    /** for debugging **/
    @Override
    public String toString () {
        return "Publisher - Name: " + this.NAME + " Email: " + this.EMAIL +
                " Phone: " + this.PHONE;
    }
}
