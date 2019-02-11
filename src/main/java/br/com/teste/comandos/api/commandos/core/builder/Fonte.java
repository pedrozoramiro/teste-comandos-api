package br.com.teste.comandos.api.commandos.core.builder;

import br.com.teste.comandos.api.commandos.core.dados.TipoFonte;

public interface Fonte {
    Construir fonte(TipoFonte tipo, String caminhoArquivo);
}
