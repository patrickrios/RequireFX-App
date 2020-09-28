package model.database;

import model.exception.MissingParameterException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UpdateRow extends DAO{
    private String update = "UPDATE $table SET $values WHERE $cond" ;

    public UpdateRow(String table, String column, Integer ID){
        this.update = update.replace("$table", table);
        this.update = this.update.replace("$cond", column+"="+ID);
    }

    public void updateByID(ArrayList<String> columns, ArrayList<?> values){
        try {
            if (columns.size() != values.size()) throw new MissingParameterException(this.update);
            prepareUpdateColumns(columns);
            PreparedStatement st = super.defineValues(values, this.update);
            st.executeUpdate();
        } catch (SQLException | MissingParameterException throwables) {
            throwables.printStackTrace();
        }
    }

    private void prepareUpdateColumns(ArrayList<String> columns){
        int quantity = columns.size();
        String state = "";

        for(int i=0; i<quantity; i++){
            state = state.concat( columns.get(i)+"=?" );
            if(i+1 < quantity)
                state = state.concat(", ");
        }
        this.update = this.update.replace("$values", state);
        System.out.println(this.update);
    }

}
