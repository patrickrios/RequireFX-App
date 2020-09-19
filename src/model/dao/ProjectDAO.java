package model.dao;

import model.database.FindRow;
import model.database.InsertRow;
import java.util.ArrayList;
import java.util.Arrays;

public class ProjectDAO {
    String table = "rfx_project";
    ArrayList<String> columns;

    public ProjectDAO(){
        this.columns = new ArrayList<>();
        this.columns.add("name");
        this.columns.add("description");
    }

    public void create(Object...list){
        ArrayList<Object> values = new ArrayList<>(Arrays.asList(list));
        InsertRow row = new InsertRow(this.table);
        row.insert(this.columns, values);
    }

    public boolean findByName(String name){
        FindRow find = new FindRow(this.table);
        return find.existOnTable("name", name);
    }
}
