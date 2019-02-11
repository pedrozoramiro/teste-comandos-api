package br.com.teste.comandos.api.commandos.csv;

import br.com.teste.comandos.api.commandos.core.ComandoContract;
import br.com.teste.comandos.api.exception.CommandoNotFound;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComandoFactoryCSVTest {
    @Test
    public void deveCriarComandoFilter() {
        ComandoContract comando = new ComandoFactoryCSV().criarComando("filter uf RO", new FakeFonteDados());
        assertEquals(FilterComandoCSV.class,comando.getClass());
    }

    @Test
    public void deveCriarComandoCount() {
        ComandoContract comando = new ComandoFactoryCSV().criarComando("count *", new FakeFonteDados());
        assertEquals(CountComandoCSV.class,comando.getClass());
    }

    @Test
    public void deveCriarComandoCountDistinct() {
        ComandoContract comando = new ComandoFactoryCSV().criarComando("count distinct uf", new FakeFonteDados());
        assertEquals(CountDistinctComandoCSV.class,comando.getClass());
    }


    @Test(expected = CommandoNotFound.class)
    public void deveLancarExcecaoQuandoComandoNaoForEncontrado() {
        ComandoContract comando = new ComandoFactoryCSV().criarComando("select * from uf", null);
        assertEquals(CountDistinctComandoCSV.class,comando.getClass());
    }
}