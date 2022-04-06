package model;

import javax.persistence.*;

@Entity
public class Writing_Group extends Authoring_Entity{
    @Column(length = 80, nullable = false)
    private String head_writer;

    @Column(nullable = false)
    private int year_formed;

    public Writing_Group (String email, String authoring_entity_type, String name, String head_writer, int year_formed){
        this.setEmail(email);
        this.setAuthoring_Entity_Type(authoring_entity_type);
        this.setName(name);
        this.setHead_Writer(head_writer);
        this.setYear_Formed(year_formed);
    }

    public Writing_Group() {}

    public void setHead_Writer(String head_writer) {
        this.head_writer = head_writer;
    }
    public String getHead_Writer() {
        return head_writer;
    }

    public void setYear_Formed(int year_formed) {
        this.year_formed = year_formed;
    }
    public int getYear_Formed() {
        return year_formed;
    }

    @Override
    public String toString () {
        return "Writing_Group - Head Writer: " + this.getHead_Writer() +
        " Year Formed: " + this.getYear_Formed();
    }
}
