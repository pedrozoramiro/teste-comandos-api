package br.com.teste.comandos.api.exception;


import br.com.teste.comandos.api.commandos.core.dados.TipoFonte;

public class CommandoNotFound extends RuntimeException {
    public CommandoNotFound(String comandoTexto, TipoFonte tipoFonte) {
        super("Comando nao encontrado [" + comandoTexto + "] para o tipo de dados " + tipoFonte.name());
    }


}
