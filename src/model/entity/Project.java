package model.entity;

import model.dao.ProjectDAO;
import model.exception.AlreadyExistsExpcetion;
import model.util.Listable;

import java.security.Timestamp;
import java.util.ArrayList;

public class Project{
    private int ID;
    private String name;
    private String description;
    private Timestamp created;
    private Timestamp lastUpdate;

    public Project(String name, String description, int id){
        this.name = name;
        this.description = description;
        this.ID = id;
    }
    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void verifyExistence() throws AlreadyExistsExpcetion {
        if( new ProjectDAO().findByName(this.name) )
            throw new AlreadyExistsExpcetion(this.name);
    }

    public void saveNewProject() {
        new ProjectDAO().create(this.name, this.description);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getID() {
        return ID;
    }
}