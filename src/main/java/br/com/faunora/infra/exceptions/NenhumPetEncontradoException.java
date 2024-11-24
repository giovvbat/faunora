package br.com.faunora.infra.exceptions;

public class NenhumPetEncontradoException extends RuntimeException {
    private static final String defaultMessage = "nenhum pet encontrado";

    public NenhumPetEncontradoException() {
        super(defaultMessage);
    }

    public NenhumPetEncontradoException(String message) {
        super(message);
    }
}
