package model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindRow extends DAO{
    private String select = "SELECT $row FROM $table WHERE $cond";

    public FindRow(String table){
        this.select = select.replace("$table", table);
    }

    public boolean existOnTable(String column, Object value){
        boolean exists = false;
        this.select = select.replace("$row", column);
        this.select = select.replace("$cond", column+" = ?");
        PreparedStatement statement = super.defineValue(value, this.select);
        try {
            ResultSet result = statement.executeQuery();
            exists = result.isBeforeFirst();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return exists;
    }
}
