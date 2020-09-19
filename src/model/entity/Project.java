package model.entity;

import model.dao.ProjectDAO;
import model.exception.AlreadyExistsExpcetion;
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

    public void verifyExistence() throws AlreadyExistsExpcetion {
        if( new ProjectDAO().findByName(this.name) )
            throw new AlreadyExistsExpcetion(this.name);
    }

    public void saveNewProject() {
        new ProjectDAO().create(this.name, this.description);
    }
}