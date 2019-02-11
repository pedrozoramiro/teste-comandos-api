package br.com.teste.comandos.api.exception;

public class ParametroNotFound extends RuntimeException {
    public ParametroNotFound(String descricao) {
        super(descricao);
    }
}
