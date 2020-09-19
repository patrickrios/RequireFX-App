package model.database;

import model.dao.ProjectDAO;
import model.entity.Project;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        ProjectDAO dao = new ProjectDAO();
        ArrayList<Project> items = dao.loadGroup(0, 15);

        for (Project p : items){
            System.out.println(p.getName()+", "+p.getDescription());
        }

    }
}
