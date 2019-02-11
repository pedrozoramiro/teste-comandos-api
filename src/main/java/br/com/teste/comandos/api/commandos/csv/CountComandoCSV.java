package br.com.teste.comandos.api.commandos.csv;

import br.com.teste.comandos.api.commandos.core.dados.FonteDados;
import br.com.teste.comandos.api.commandos.core.resultado.ResultadoCommando;
import br.com.teste.comandos.api.commandos.core.resultado.ResultadoListaCommando;

import java.util.concurrent.atomic.AtomicLong;


public class CountComandoCSV extends ComandoCSV {

    public static final String COMANDO_TAG = "count *";

    public CountComandoCSV(String comandoTexto, FonteDados fonteDadas) {
        super(comandoTexto, fonteDadas);
    }

    @Override
    public ResultadoCommando execute() {
        AtomicLong total = new AtomicLong();
        lerLinha((linha) -> total.getAndIncrement());
        return new ResultadoCommando<>(total.get());
    }
}
