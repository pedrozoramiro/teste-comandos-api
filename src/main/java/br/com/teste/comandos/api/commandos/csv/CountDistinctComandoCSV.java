package br.com.teste.comandos.api.commandos.csv;

import br.com.teste.comandos.api.commandos.core.dados.FonteDados;
import br.com.teste.comandos.api.commandos.core.resultado.ResultadoCommando;
import br.com.teste.comandos.api.commandos.core.resultado.ResultadoListaCommando;
import br.com.teste.comandos.api.exception.ParametroNotFound;

import java.util.Set;
import java.util.TreeSet;

public class CountDistinctComandoCSV extends ComandoCSV {

    public static final String COMANDO_TAG = "count distinct";
    private static final Integer PARAMETRO_INDICE_NOME_CAMPO = 2;

    private String nomeDoCampo;

    public CountDistinctComandoCSV(String comandoTexto, FonteDados fonteDadas) {
        super(comandoTexto, fonteDadas);
        validarParamerosObrigatorios();
        nomeDoCampo = getParametro(PARAMETRO_INDICE_NOME_CAMPO);
    }

    private void validarParamerosObrigatorios() {
        if (!existeParametro(PARAMETRO_INDICE_NOME_CAMPO)) {
            throw new ParametroNotFound("Nome da propriedade a efetuar distinct");
        }

    }

    @Override
    public ResultadoCommando execute() {
        Set<String> nomes = new TreeSet<>();
        Integer indiceCampo = getIndiceCampo(nomeDoCampo);
        lerLinha((linha) -> nomes.add(linha[indiceCampo]));
        return new ResultadoCommando<>(nomes.size());
    }
}
