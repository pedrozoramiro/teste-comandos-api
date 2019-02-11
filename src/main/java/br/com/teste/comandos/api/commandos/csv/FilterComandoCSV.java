package br.com.teste.comandos.api.commandos.csv;

import br.com.teste.comandos.api.commandos.core.dados.FonteDados;
import br.com.teste.comandos.api.commandos.core.resultado.ResultadoListaCommando;
import br.com.teste.comandos.api.exception.ParametroNotFound;

import java.util.ArrayList;
import java.util.List;


public class FilterComandoCSV extends ComandoCSV {
    public static final String COMANDO_TAG = "filter";
    private static final Integer PARAMETRO_INDICE_NOME_CAMPO = 1;
    private static final Integer PARAMETRO_INDICE_VALOR_CAMPO = 2;

    private final String nomeDoCampo;
    private final String valor;


    public FilterComandoCSV(String comandoTexto, FonteDados fonteDados) {
        super(comandoTexto, fonteDados);
        validarParamerosObrigatorios();
        nomeDoCampo = getParametro(PARAMETRO_INDICE_NOME_CAMPO);
        valor = getParametro(PARAMETRO_INDICE_VALOR_CAMPO);
    }

    private void validarParamerosObrigatorios() {
        if (!existeParametro(PARAMETRO_INDICE_NOME_CAMPO)) {
            throw new ParametroNotFound("Nome da propriedade a efetuar filter");
        }
        if (!existeParametro(PARAMETRO_INDICE_VALOR_CAMPO)) {
            throw new ParametroNotFound("valor da propriedade a efetuar filter");
        }

    }
    @Override
    public ResultadoListaCommando execute() {
        List<String> linhas = new ArrayList<>();
        Integer indiceCampo = getIndiceCampo(nomeDoCampo);
        lerLinha((linha) -> {
            if (valor.equals(linha[indiceCampo])) {
                linhas.add(String.join(",", linha));
            }
        });
        return new ResultadoListaCommando<>(linhas,getHeaders());
    }


}
