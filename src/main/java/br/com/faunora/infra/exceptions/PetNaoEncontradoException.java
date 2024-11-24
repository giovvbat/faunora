package br.com.faunora.infra.exceptions;

public class PetNaoEncontradoException extends RuntimeException {
    private static final String defaultMessage = "pet não encontrado";

    public PetNaoEncontradoException() {
        super(defaultMessage);
    }

    public PetNaoEncontradoException(String message) {
        super(message);
    }
}
