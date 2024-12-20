package br.com.faunora.infra.exceptions.exames;

public class ExameNaoEncontradoException extends RuntimeException {
    private static final String defaultMessage = "exame não encontrado";

    public ExameNaoEncontradoException() {
        super(defaultMessage);
    }

    public ExameNaoEncontradoException(String message) {
        super(message);
    }
}
