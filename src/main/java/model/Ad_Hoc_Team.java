package model;

import javax.persistence.*;

@Entity
public class Ad_Hoc_Team  extends Authoring_Entity{

    public Ad_Hoc_Team (String email, String authoring_entity_type, String name){
        this.setEmail(email);
        this.setAuthoring_Entity_Type(authoring_entity_type);
        this.setName(name);
    }
    public Ad_Hoc_Team() {}
}
