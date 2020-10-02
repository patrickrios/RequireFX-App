package model.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRow extends DAO{
    private String delete = "DELETE FROM $table WHERE $cond";

    public DeleteRow(String table){
        this.delete = delete.replace("$table", table);
    }

    public void deleteByID(String column, Integer id){
        this.delete = delete.replace("$cond", column+"=?");

        try {
            PreparedStatement statement = super.defineValue(id, this.delete);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
