package br.com.teste.comandos.api.commandos.core.builder;

import br.com.teste.comandos.api.commandos.core.AbstractCommandFactory;
import br.com.teste.comandos.api.commandos.core.ComandoContract;
import br.com.teste.comandos.api.commandos.core.dados.TipoFonte;
import br.com.teste.comandos.api.commandos.csv.FonteDadosCSV;

public class ComandosBuilder implements Acao, Fonte, Construir {


    private String comandoTexto;
    private TipoFonte tipoFonte;
    private String caminhoArquivo;

    private ComandosBuilder() {
    }


    public static ComandosBuilder criar() {
        return new ComandosBuilder();
    }

    public Fonte acao(String comandoTexto) {
        this.comandoTexto = comandoTexto;
        return this;
    }

    public Construir fonte(TipoFonte tipo, String caminhoArquivo) {
        this.tipoFonte = tipo;
        this.caminhoArquivo = caminhoArquivo;
        return this;

    }

    public ComandoContract construir() {
        return AbstractCommandFactory.obterFactory(tipoFonte).criarComando(comandoTexto, new FonteDadosCSV(caminhoArquivo));
    }
}
