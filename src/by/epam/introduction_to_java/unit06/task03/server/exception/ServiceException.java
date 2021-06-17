package by.epam.introduction_to_java.unit06.task03.server.exception;

public class ServiceException extends Exception{

    public ServiceException (String message){
        super(message);
    }

    public ServiceException (Exception e){
        super(e);
    }

    public ServiceException (String message, Exception e){
        super(message,e);
    }

    public ServiceException (){
        super();
    }
}
