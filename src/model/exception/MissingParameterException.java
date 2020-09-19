package model.exception;

public class MissingParameterException extends Exception{
    private final String statement;
    public MissingParameterException(String statement){
        this.statement = statement;
    }
    public String detail(){
        return "SOME PARAMETER ARE MISSING ON STATEMENT: "+this.statement;
    }
}
