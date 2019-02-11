package br.com.teste.comandos.api.commandos.csv;

import br.com.teste.comandos.api.commandos.core.resultado.ResultadoCommando;
import br.com.teste.comandos.api.exception.FonteDadosNotFound;
import br.com.teste.comandos.api.exception.TextoComandoInvalido;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountComandoCSVTest {


    @Test(expected = FonteDadosNotFound.class)
    public void deveLancarExcecaoQuandoFonteDadosForNulo() {
        new CountComandoCSV("count *", null);
    }

    @Test(expected = TextoComandoInvalido.class)
    public void deveLancarExcecaoQuandoTextoComandoForNulo() {
        new CountComandoCSV(null, new FakeFonteDados());
    }

    @Test()
    public void deveTotalizarTodosOsRegistros() {
        ResultadoCommando<Long> totalRegistros = new CountComandoCSV("count *", new FakeFonteDados()).execute();
        assertEquals(10, totalRegistros.getDados().longValue());
    }


}