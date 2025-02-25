package main.exceptions;

public class AtividadeNaoEncontradaException extends Exception {
    public AtividadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}