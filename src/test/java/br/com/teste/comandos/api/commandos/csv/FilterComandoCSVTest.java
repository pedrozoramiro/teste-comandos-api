package br.com.teste.comandos.api.commandos.csv;

import br.com.teste.comandos.api.commandos.core.resultado.ResultadoCommando;
import br.com.teste.comandos.api.commandos.core.resultado.ResultadoListaCommando;
import br.com.teste.comandos.api.exception.FonteDadosNotFound;
import br.com.teste.comandos.api.exception.ParametroNotFound;
import br.com.teste.comandos.api.exception.TextoComandoInvalido;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FilterComandoCSVTest {


    @Test(expected = FonteDadosNotFound.class)
    public void deveLancarExcecaoQuandoFonteDadosForNulo() {
        new FilterComandoCSV("filter uf SC", null);
    }

    @Test(expected = TextoComandoInvalido.class)
    public void deveLancarExcecaoQuandoTextoComandoForNulo() {
        new FilterComandoCSV(null, new FonteDadosCSV(""));
    }

    @Test(expected = ParametroNotFound.class)
    public void deveLancarExcecaoQuandoParametroPropriedadeNaoFoiPassada() {
        new FilterComandoCSV("filter", new FonteDadosCSV(""));
    }

    @Test(expected = ParametroNotFound.class)
    public void deveLancarExcecaoQuandoParametroPropriedadeNaoFoiPassadaa() {
        new FilterComandoCSV("filter uf", new FonteDadosCSV(""));
    }

    @Test
    public void deveFiltrarPorValorProperiedadePAssada() {
        ResultadoListaCommando<List<String>> dadosFiltrado = new FilterComandoCSV("filter uf SC", new FakeFonteDados())
                .execute();
        assertEquals(2, dadosFiltrado.getDados().size());
    }



}