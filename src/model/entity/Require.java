package model.entity;

import model.dao.RequireDAO;

import java.sql.Timestamp;

public class Require implements Persistent{
    private Integer ID;
    private Integer projectID;
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

    public Require(String name, Integer projectID, int type){
        this.name = name;
        this.projectID = projectID;
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
        int inserted = 0;
        if (this.ID == null) {
            this.ID = new RequireDAO(this.projectID).create(this.name, this.type);
        }else{
            //TODO update require
            inserted = 0;
        }
        return inserted;
    }

    @Override
    public void updateThis() {

    }

    @Override
    public void deleteThis() {

    }

    public Integer getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
}