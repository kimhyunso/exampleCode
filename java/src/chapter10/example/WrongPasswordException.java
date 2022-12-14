package chapter10.example;

public class WrongPasswordException extends Exception{
    public WrongPasswordException(){}
    public WrongPasswordException(String message){
        super(message);
    }
}
