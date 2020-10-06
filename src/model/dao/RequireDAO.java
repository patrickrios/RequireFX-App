package model.dao;

import model.database.FindGroup;
import model.database.InsertRow;
import model.entity.Require;
import model.util.Listable;
import java.util.ArrayList;

public class RequireDAO implements Listable {
    private final String table = "rfx_require";
    private final ArrayList<String> insertColumns;
    private final int projectID;

    public RequireDAO(int projectID){
        this.projectID = projectID;
        this.insertColumns = new ArrayList<>();
        this.insertColumns.add("name");
        this.insertColumns.add("project_id");
        this.insertColumns.add("type_id");
    }

    public Integer create(String name, int type){
        ArrayList<Object> values = new ArrayList<>();
        values.add(name);
        values.add(this.projectID);
        values.add(type);
        InsertRow insert = new InsertRow(this.table);
        return insert.insert(this.insertColumns, values);
    }

    @Override
    public ArrayList<Require> loadGroup(int offset, int limit) {
        FindGroup find = new FindGroup(this.table);
        ArrayList<Require> items = new ArrayList<>();
        String columnFind = "project_id";
        for(Object o : find.getItemsOf(this.insertColumns, offset, limit, columnFind, projectID)){
            ArrayList<Object> datas = (ArrayList<Object>) o;
            items.add( new Require(datas.get(0).toString(), (int)datas.get(1), (int)datas.get(2)));
        }
        return items;
    }

    @Override
    public int getTotal() {
        return 0;
    }
}
