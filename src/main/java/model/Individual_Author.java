package model;

public class Individual_Author extends Authoring_Entity{
    public Individual_Author (String email, String authoring_entity_type, String name){
        this.setEmail(email);
        this.setAuthoring_Entity_Type(authoring_entity_type);
        this.setName(name);
    }

    public Individual_Author() {}
    
}
