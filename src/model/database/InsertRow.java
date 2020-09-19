package model.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsertRow extends DAO
{
    private String insert = "INSERT INTO $table($columns) VALUES($values)";

    public InsertRow(String table){
        this.insert = this.insert.replace("$table", table);
    }

    public void insert(ArrayList<String> columns, ArrayList<?> values){
        try {
            this.prepareInsertStatement(columns);
            PreparedStatement query = super.defineValues(values, this.insert);
            query.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void prepareInsertStatement(ArrayList<String> colsName){
        int listSize = colsName.size();
        StringBuilder cols = new StringBuilder();
        StringBuilder sets = new StringBuilder();
        for(int i =0; i<listSize; i++){
            sets.append("?");
            cols.append(colsName.get(i));
            if(i+1 < listSize){
                sets.append(",");
                cols.append(",");
            }
        }
        this.insert = this.insert.replace("$columns", cols.toString());
        this.insert = this.insert.replace("$values", sets.toString());
    }
}