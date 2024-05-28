package jtm.activity08;

public class SimpleCalcException extends Exception{
    
    private static final long serialVersionUID = -8183367738219671137L; //todo change this

    public SimpleCalcException(String message) {
        super(message);
    }

    public SimpleCalcException(String message, Throwable cause) {
        super(message, cause);
    }

}
