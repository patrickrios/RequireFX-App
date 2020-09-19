package model.database;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        ArrayList<Object> values = new ArrayList<>();
        values.add("Teste string builder");
        values.add(23);
        values.add(234.45f);
        values.add(new Timestamp(new Date().getTime()));


        for (Object o : values){
            System.out.println(o.getClass().getTypeName());
        }

    }
}
