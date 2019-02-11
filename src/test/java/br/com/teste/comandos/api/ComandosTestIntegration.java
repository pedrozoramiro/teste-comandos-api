package br.com.teste.comandos.api;

import br.com.teste.comandos.api.commandos.core.builder.ComandosBuilder;
import br.com.teste.comandos.api.commandos.core.dados.TipoFonte;
import br.com.teste.comandos.api.commandos.core.resultado.ResultadoCommando;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ComandosTestIntegration {


    @Test
    public void deveExecutarContagemTotalDeTodosRegistrosImportados() {
        ResultadoCommando<Long> total = ComandosBuilder
                .criar()
                .acao("count *")
                .fonte(TipoFonte.CSV, "/cidade.csv")
                .construir()
                .execute();

        Assert.assertEquals(total.getDados().longValue(), 5565L);
    }

    @Test
    public void deveExecutarContagemTotalDisctint() {
        ResultadoCommando<Integer> total = ComandosBuilder
                .criar()
                .acao("count distinct uf")
                .fonte(TipoFonte.CSV, "/cidade.csv")
                .construir()
                .execute();
        Assert.assertEquals(27, total.getDados().intValue());
    }

    @Test
    public void deveExecutarFiltroPorCampoEspecifico() {
        ResultadoCommando<List<String>> resultado = ComandosBuilder
                .criar()
                .acao("filter uf RO")
                .fonte(TipoFonte.CSV, "/cidade.csv")
                .construir()
                .execute();
        Assert.assertEquals(52, resultado.getDados().size());
    }
}