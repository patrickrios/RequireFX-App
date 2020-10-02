package model.database;

import model.exception.MissingParameterException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsertRow extends DAO
{
    private String insert = "INSERT INTO $table($columns) VALUES($values)";

    public InsertRow(String table){
        this.insert = this.insert.replace("$table", table);
    }

    public Integer insert(ArrayList<String> columns, ArrayList<?> values){
        Integer result = null;
        try {
            if (columns.size() != values.size()) throw new MissingParameterException(this.insert);
            this.prepareInsertStatement(columns);
            PreparedStatement query = super.defineValues(values, this.insert);
            int rows = query.executeUpdate();

            if (rows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = query.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    result = generatedKeys.getInt(1);
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

        }
        catch (SQLException | MissingParameterException throwables) {
            throwables.printStackTrace();
        }
        return result;
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