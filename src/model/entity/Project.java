package model.entity;

import model.dao.ProjectDAO;
import model.exception.AlreadyExistsExpcetion;
import java.security.Timestamp;

public class Project{
    private Integer ID;
    private String name;
    private String description;
    private Timestamp created;
    private Timestamp lastUpdate;

    public Project(String name, String description, Integer id){
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
        this.ID = new ProjectDAO().create(this.name, this.description);
    }

    public void updateThis(String name, String description){
        new ProjectDAO().updateProjectById(this.ID, name, description);
    }

    public void deleteThis(){
        new ProjectDAO().deleteById(this.ID);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getID() {
        return ID;
    }
}