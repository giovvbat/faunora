package br.com.faunora.infra.exceptions;

public class NenhumProdutoEncontradoException extends RuntimeException {
    private static final String defaultMessage = "nenhum produto encontrado";

    public NenhumProdutoEncontradoException() {
        super(defaultMessage);
    }

    public NenhumProdutoEncontradoException(String message) {
        super(message);
    }
}
