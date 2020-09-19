package model.exception;

public class AlreadyExistsExpcetion  extends Exception{
    String name;
    public AlreadyExistsExpcetion(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
