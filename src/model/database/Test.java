package model.database;

import model.dao.ProjectDAO;
import model.entity.Project;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        UpdateRow up = new UpdateRow("rfx_project", "project_id", 19);

        ArrayList<String> columns = new ArrayList<>();
        columns.add("name");
        columns.add("description");

        ArrayList<Object> values = new ArrayList<>();
        values.add("Meu projeto");
        values.add("Descrição qualquer");

        up.updateByID(columns, values);
    }
}
