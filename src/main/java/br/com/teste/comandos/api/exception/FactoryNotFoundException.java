package br.com.teste.comandos.api.exception;

import br.com.teste.comandos.api.commandos.core.dados.TipoFonte;

public class FactoryNotFoundException extends RuntimeException {
    public FactoryNotFoundException(TipoFonte tipoFonte) {
        super("Factory para fonte de dados nao encontrada" + tipoFonte.name());
    }
}
