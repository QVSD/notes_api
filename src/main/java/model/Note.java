package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Note {

    @Id @GeneratedValue
    private long Id;

    private String title;
    private String description;

    public Note(){}

    public long getId(){
        return Id;
    }
    public void setId(Long Id){
        this.Id = Id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String title){
        this.description = description;
    }
}
