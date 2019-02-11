package br.com.teste.comandos.api.commandos.core.dados;

import java.util.function.Consumer;

public interface FonteDados {

    void lerArquivo(Consumer<String[]> eventoLinhas);

    void lerArquivo(Consumer<String[]> eventoHeader, Consumer<String[]> eventoLinhas);

    String[] getHeader();

    Integer getIndiceCampo(String nomeDoCampo);
}
