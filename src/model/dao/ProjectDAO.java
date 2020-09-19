package model.dao;

import model.database.FindGroup;
import model.database.FindRow;
import model.database.InsertRow;
import model.entity.Project;
import model.exception.MissingParameterException;
import model.util.Listable;

import java.util.ArrayList;
import java.util.Arrays;

public class ProjectDAO implements Listable {
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

    @Override
    public ArrayList<Project> loadGroup(int offset, int limit) {
        FindGroup group = new FindGroup(this.table);
        ArrayList<Project> list = new ArrayList<>();
        for(Object o : group.getItems(this.columns, offset, limit)){
            ArrayList<Object> datas = (ArrayList<Object>) o;
            list.add(new Project(datas.get(0).toString(), datas.get(1).toString()) );
        }
        return list;
    }

    @Override
    public int getTotal() {
        return 0;
    }
}
