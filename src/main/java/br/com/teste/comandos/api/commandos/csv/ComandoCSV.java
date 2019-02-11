package br.com.teste.comandos.api.commandos.csv;

import br.com.teste.comandos.api.commandos.core.ComandoContract;
import br.com.teste.comandos.api.commandos.core.dados.FonteDados;
import br.com.teste.comandos.api.commandos.core.resultado.ResultadoCommando;
import br.com.teste.comandos.api.exception.FonteDadosNotFound;
import br.com.teste.comandos.api.exception.TextoComandoInvalido;

import java.util.function.Consumer;

public abstract class ComandoCSV implements ComandoContract {

    private final String[] parametros;
    private FonteDados fonteDados;

    public ComandoCSV(String comandoTexto, FonteDados fonteDados) {
        validar(comandoTexto, fonteDados);
        this.parametros = comandoTexto.split(" ");
        this.fonteDados = fonteDados;
    }
    protected void lerLinha(Consumer<String[]> linha) {
        fonteDados.lerArquivo(linha);
    }
    protected String getParametro(Integer indiceParametro) {
        return parametros[indiceParametro];
    }
    protected boolean existeParametro(Integer indiceParametro) {
        return indiceParametro < parametros.length;
    }
    protected Integer getIndiceCampo(String nomeDoCampo) {
        return fonteDados.getIndiceCampo(nomeDoCampo);
    }
    private void validar(String comandoTexto, FonteDados fonteDados) {
        if (fonteDados == null) {
            throw new FonteDadosNotFound();
        }
        if (comandoTexto == null) {
            throw new TextoComandoInvalido();
        }

    }
    protected String[] getHeaders() {
        return fonteDados.getHeader();
    }
    public abstract <T> ResultadoCommando<T> execute();
}
