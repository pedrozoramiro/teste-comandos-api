package br.com.teste.comandos.api.commandos.core;

import br.com.teste.comandos.api.commandos.core.resultado.ResultadoCommando;

public interface ComandoContract {

    <T> ResultadoCommando<T> execute();
}
