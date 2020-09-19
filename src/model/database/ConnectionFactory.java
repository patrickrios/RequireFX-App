package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory{

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/requirefx?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        }
        catch(SQLException excecao){
            throw new RuntimeException(excecao);
        }
    }
}