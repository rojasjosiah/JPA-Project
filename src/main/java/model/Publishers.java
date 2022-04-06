package model;
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
    private String name;

    @Column(length = 80, nullable = false, unique = true)
    private String email;

    @Column(length = 24, nullable = false, unique = true)
    private String phone;

    public Publishers (String name, String email, String phone){
        this.setName(name);
        this.setEmail(email);
        this.setPhone(phone);
    }

    public Publishers () {}

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /** for debugging **/
    @Override
    public String toString () {
        return "Publisher - Name: " + this.name + " Email: " + this.email +
                " Phone: " + this.phone;
    }
}
