package model.entity;

import java.sql.Timestamp;

public class Require implements Persistent{
    private Integer ID;
    private String name;
    private boolean done;
    private Timestamp createDate;
    private Timestamp lastUpdate;
    private int type;

    public Require(Integer ID, String name,boolean done, int type){
        this.ID = ID;
        this.name = name;
        this.done= done;
        this.type = type;
    }

    public Require(String name,boolean done, int type){
        this.name = name;
        this.done = done;
        this.type = type;
    }


    public String getTypeName(){
        String typeName = "";
        if (this.type == 1)
            typeName = "RF";
        else if (this.type == 2)
            typeName = "RNF";
        else
            typeName = "RN";
        return typeName;
    }

    @Override
    public int saveThis() {
        return 0;
    }

    @Override
    public void updateThis() {

    }

    @Override
    public void deleteThis() {

    }
}