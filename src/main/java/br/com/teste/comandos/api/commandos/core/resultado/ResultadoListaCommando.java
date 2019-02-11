package br.com.teste.comandos.api.commandos.core.resultado;

import java.util.List;

public class ResultadoListaCommando<T extends List> extends ResultadoCommando<T> {
    private String[] header;

    public ResultadoListaCommando(T dados, String[] header) {
        super(dados);
        this.header = header;
    }

    @Override
    public void escreveNoConsole() {
        System.out.println(String.join(",", header));
        getDados().forEach(System.out::println);

    }
}
