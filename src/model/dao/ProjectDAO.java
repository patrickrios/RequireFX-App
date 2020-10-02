package model.dao;

import model.database.*;
import model.entity.Project;
import model.util.Listable;
import java.util.ArrayList;
import java.util.Arrays;

public class ProjectDAO implements Listable {
    final private String table    = "rfx_project";
    final private String columnID = "project_id";
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
        this.columns.add("project_id");
        for(Object o : group.getItems(this.columns, offset, limit)){
            ArrayList<Object> datas = (ArrayList<Object>) o;
            list.add(new Project(datas.get(0).toString(), datas.get(1).toString(), (int)datas.get(2)) );
        }
        return list;
    }

    @Override
    public int getTotal() {
        return 0;
    }

    public boolean updateProjectById(Integer id, Object... values){
        ArrayList<Object> list = new ArrayList<>(Arrays.asList(values));
        UpdateRow update = new UpdateRow(this.table, this.columnID, id);
        update.updateByID(this.columns, list);
        return true;
    }

    public boolean deleteById(Integer id){
        DeleteRow delete = new DeleteRow(this.table);
        delete.deleteByID(this.columnID, id);
        return true;
    }
}
