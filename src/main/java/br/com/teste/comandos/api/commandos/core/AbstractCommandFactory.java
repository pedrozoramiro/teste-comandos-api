package br.com.teste.comandos.api.commandos.core;

import br.com.teste.comandos.api.commandos.core.dados.FonteDados;
import br.com.teste.comandos.api.commandos.core.dados.TipoFonte;
import br.com.teste.comandos.api.commandos.csv.ComandoFactoryCSV;
import br.com.teste.comandos.api.exception.FactoryNotFoundException;

public abstract class AbstractCommandFactory {
    protected final TipoFonte tipoFonte;

    public static AbstractCommandFactory obterFactory(TipoFonte fonte) {
        switch (fonte) {
            case CSV:
                return new ComandoFactoryCSV();
            default:
                throw new FactoryNotFoundException(fonte);

        }
    }

    public AbstractCommandFactory(TipoFonte tipoFonte) {
        this.tipoFonte = tipoFonte;
    }

    public abstract ComandoContract criarComando(String comandoTexto, FonteDados fonteDados) ;

}
