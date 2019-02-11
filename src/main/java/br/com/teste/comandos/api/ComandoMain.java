package br.com.teste.comandos.api;

import br.com.teste.comandos.api.commandos.core.builder.ComandosBuilder;
import br.com.teste.comandos.api.commandos.core.dados.TipoFonte;

public class ComandoMain {

    public static void main(String[] args) {
        ComandosBuilder
                .criar()
                .acao(String.join(" ", args))
                .fonte(TipoFonte.CSV, "/cidade.csv")
                .construir()
                .execute()
                .escreveNoConsole();
    }
}
