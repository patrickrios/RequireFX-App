package model.dao;

import model.database.InsertRow;

import java.util.ArrayList;

public class RequireDAO{
    private final String table = "rfx_require";
    private final String columndID = "require_id";
    private ArrayList<String> insertColumns;

    public RequireDAO(){
        this.insertColumns = new ArrayList<>();
        this.insertColumns.add("name");
        this.insertColumns.add("project_id");
        this.insertColumns.add("type_id");
    }

    public Integer create(String name, Integer ID, int type){
        ArrayList<Object> values = new ArrayList<>();
        values.add(name);
        values.add(ID);
        values.add(type);
        InsertRow insert = new InsertRow(this.table);
        return insert.insert(this.insertColumns, values);
    }

}
