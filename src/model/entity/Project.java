package model.entity;

import java.security.Timestamp;

public class Project {
    private int ID;
    private String name;
    private String description;
    private Timestamp created;
    private Timestamp lastUpdate;

    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void verifyExistence(){
        //TODO
    }

    public void saveNewProject(){
        //TODO
    }
}