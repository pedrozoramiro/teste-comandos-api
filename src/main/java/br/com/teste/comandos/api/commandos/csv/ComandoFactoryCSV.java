package br.com.teste.comandos.api.commandos.csv;

import br.com.teste.comandos.api.commandos.core.AbstractCommandFactory;
import br.com.teste.comandos.api.commandos.core.ComandoContract;
import br.com.teste.comandos.api.commandos.core.dados.FonteDados;
import br.com.teste.comandos.api.commandos.core.dados.TipoFonte;
import br.com.teste.comandos.api.exception.CommandoNotFound;

public class ComandoFactoryCSV extends AbstractCommandFactory {

    public ComandoFactoryCSV() {
        super(TipoFonte.CSV);
    }

    @Override
    public ComandoContract criarComando(String comandoTexto, FonteDados fonteDados) {
        if (comandoTexto.startsWith(CountComandoCSV.COMANDO_TAG)) {
            return new CountComandoCSV(comandoTexto, fonteDados);
        }
        if (comandoTexto.startsWith(FilterComandoCSV.COMANDO_TAG)) {
            return new FilterComandoCSV(comandoTexto, fonteDados);
        }
        if (comandoTexto.startsWith(CountDistinctComandoCSV.COMANDO_TAG)) {
            return new CountDistinctComandoCSV(comandoTexto, fonteDados);
        }
        throw new CommandoNotFound(comandoTexto, tipoFonte);
    }
}
