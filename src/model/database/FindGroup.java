package model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FindGroup extends DAO{
    private String select   = "SELECT $columns FROM $table LIMIT $lim OFFSET $off ";
    private String selectOf = "SELECT $columns FROM $table WHERE $cond LIMIT $lim OFFSET $off ";

    public FindGroup(String table){
        this.select = select.replace("$table", table);
        this.selectOf = selectOf.replace("$table", table);
    }

    public ArrayList<?> getItems(ArrayList<String> columns, int offset, int limit ){
        ArrayList<Object> items = new ArrayList<>();
        try {
            String state = this.prepareColumns(columns);
            this.select = select.replace("$columns", state);
            this.select = select.replace("$off", offset+"");
            this.select = select.replace("$lim", limit+"");

            PreparedStatement statement = super.getConn().prepareStatement(this.select);
            ResultSet result = statement.executeQuery();

            while (result.next()){
                int columnCount = result.getMetaData().getColumnCount();
                ArrayList<Object> datas = new ArrayList<>();
                for(int i=1; i<=columnCount; i++){
                    datas.add(result.getObject(i));
                }
                items.add(datas);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return items;
    }

    public ArrayList<?> getItemsOf(ArrayList<String> columns, int offset, int limit,  String columnID, int ID ){
        ArrayList<Object> items = new ArrayList<>();
        try {
            String state = this.prepareColumns(columns);
            this.selectOf = selectOf.replace("$columns", state);
            this.selectOf = selectOf.replace("$off", offset+"");
            this.selectOf = selectOf.replace("$lim", limit+"");
            this.selectOf = selectOf.replace("$cond", columnID+"=?");

            PreparedStatement statement = super.getConn().prepareStatement(this.selectOf);
            statement.setInt(1, ID);
            ResultSet result = statement.executeQuery();

            while (result.next()){
                int columnCount = result.getMetaData().getColumnCount();
                ArrayList<Object> datas = new ArrayList<>();
                for(int i=1; i<=columnCount; i++){
                    datas.add(result.getObject(i));
                }
                items.add(datas);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return items;
    }

}
