package model.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

 abstract class DAO {
    private final Connection conn;

    public DAO(){
        this.conn  = ConnectionFactory.getConnection();
    }

    protected Connection getConn(){
        return this.conn;
    }

     protected PreparedStatement defineValues(ArrayList<?> values, String sql){
         PreparedStatement statement = null;
         try {
             statement = this.getConn().prepareStatement(sql);
             int index = 1;
             for (Object obj : values) {
                 String type = obj.getClass().getTypeName();
                 switch (type) {
                     case "java.lang.String":
                         statement.setString(index, obj.toString());
                         break;
                     case "java.lang.Integer":
                         statement.setInt(index, (int) obj);
                         break;
                     case "java.lang.Float":
                         statement.setFloat(index, (float) obj);
                         break;
                     case "java.sql.Timestamp":
                         statement.setTimestamp(index, (Timestamp) obj);
                         break;
                 }
                 index++;
             }
         }
         catch (SQLException throwables) {
             throwables.printStackTrace();
         }
         return statement;
     }

     protected PreparedStatement defineValue(Object value, String sql){
         PreparedStatement statement = null;
         try {
             statement = this.getConn().prepareStatement(sql);
                 String type = value.getClass().getTypeName();
                 switch (type) {
                     case "java.lang.String":
                         statement.setString(1, value.toString());
                         break;
                     case "java.lang.Integer":
                         statement.setInt(1, (int) value);
                         break;
                     case "java.lang.Float":
                         statement.setFloat(1, (float) value);
                         break;
                     case "java.sql.Timestamp":
                         statement.setTimestamp(1, (Timestamp) value);
                         break;
                 }
         }
         catch (SQLException throwables) {
             throwables.printStackTrace();
         }
         return statement;
     }

     protected String prepareColumns(ArrayList<String> columns){
        StringBuilder columnList = new StringBuilder();
        int i = 0;
        for (String col : columns){
            columnList.append(col);
            if(i+1 < columns.size())
                columnList.append(", ");
            i++;
        }
        return columnList.toString();
     }

}