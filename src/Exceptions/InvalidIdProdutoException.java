package Exceptions;

public class InvalidIdProdutoException extends Exception{
    public InvalidIdProdutoException(String mensagem){
        super(mensagem);
    }
}
