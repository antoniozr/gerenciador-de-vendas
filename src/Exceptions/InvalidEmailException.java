package Exceptions;

public class InvalidEmailException extends Exception{
    public InvalidEmailException(String mensagem){
        super(mensagem);
    }
}
