package br.com.teste.comandos.api.commandos.csv;

import br.com.teste.comandos.api.commandos.core.resultado.ResultadoCommando;
import br.com.teste.comandos.api.exception.FonteDadosNotFound;
import br.com.teste.comandos.api.exception.ParametroNotFound;
import br.com.teste.comandos.api.exception.TextoComandoInvalido;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountDistinctComandoCSVTest {

    @Test(expected = FonteDadosNotFound.class)
    public void deveLancarExcecaoQuandoFonteDadosForNulo() {
        new CountDistinctComandoCSV("count distinct uf", null);
    }

    @Test(expected = TextoComandoInvalido.class)
    public void deveLancarExcecaoQuandoTextoComandoForNulo() {
        new CountDistinctComandoCSV(null, new FonteDadosCSV(""));
    }

    @Test(expected = ParametroNotFound.class)
    public void deveLancarExcecaoQuandoParametroPropriedadeNaoFoiPassada() {
        new CountDistinctComandoCSV("count distinct", new FonteDadosCSV(""));
    }


    @Test
    public void deveTotalizarRegistrosSemRepetirValorComBaseProperiedade() {
        ResultadoCommando<Integer> totalRegistros = new CountDistinctComandoCSV("count distinct uf", new FakeFonteDados())
                .execute();
        assertEquals(4, totalRegistros.getDados().longValue());
    }

}