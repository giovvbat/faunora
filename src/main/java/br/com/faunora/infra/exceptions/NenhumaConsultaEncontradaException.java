package br.com.faunora.infra.exceptions;

public class NenhumaConsultaEncontradaException extends RuntimeException{
    private static final String defaultMessage = "nenhuma consulta encontrada";

    public NenhumaConsultaEncontradaException() {
        super(defaultMessage);
    }

    public NenhumaConsultaEncontradaException(String message) {
        super(message);
    }
}
