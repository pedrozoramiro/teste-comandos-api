package br.com.teste.comandos.api.exception;

public class CampoCsvNotFoundException extends RuntimeException {
    public CampoCsvNotFoundException(String nomeDoCampo, String linhaHeader) {
        super("Erro ao buscar campo " + nomeDoCampo + " com o cabecalho " + linhaHeader);
    }
}
