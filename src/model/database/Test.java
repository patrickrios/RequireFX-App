package model.database;

import model.dao.ProjectDAO;
import model.entity.Project;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        DeleteRow del = new DeleteRow("rfx_project");
        del.deleteByID("project_id", 20);

    }
}
