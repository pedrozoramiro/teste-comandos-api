package br.com.teste.comandos.api.commandos.csv;

import br.com.teste.comandos.api.commandos.core.dados.FonteDados;
import br.com.teste.comandos.api.exception.CampoCsvNotFoundException;

import java.io.InputStream;
import java.util.Scanner;
import java.util.function.Consumer;

public class FonteDadosCSV implements FonteDados {
    private static final String CSV_SEPARADOR = ",";
    private String caminhoArquivo;
    private String[] header;

    public FonteDadosCSV(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    @Override
    public void lerArquivo(Consumer<String[]> eventoLinhas) {
        lerArquivo(null, eventoLinhas);
    }

    @Override
    public void lerArquivo(Consumer<String[]> eventoHeader, Consumer<String[]> eventoLinhas) {
        try (Scanner linhas = carregarLinhas()) {
            header = linhas.next().split(CSV_SEPARADOR);
            if (eventoHeader != null) {
                eventoHeader.accept(header);
            }
            while (linhas.hasNext()) {
                eventoLinhas.accept(linhas.next().split(CSV_SEPARADOR));
            }
        }
    }

    @Override
    public String[] getHeader() {
        if (header != null) {
            return header;
        }
        try (Scanner linhas = carregarLinhas()) {
            String linhaHeader = linhas.next();
            header = linhaHeader.split(CSV_SEPARADOR);
            return header;
        }
    }

    @Override
    public Integer getIndiceCampo(String nomeDoCampo) {
        String[] campos = getHeader();
        for (int indiceCampo = 0; indiceCampo < campos.length; indiceCampo++) {
            if (campos[indiceCampo].equals(nomeDoCampo)) {
                return indiceCampo;
            }
        }
        throw new CampoCsvNotFoundException(nomeDoCampo, String.join(",", campos));
    }


    private Scanner carregarLinhas() {
        InputStream resourceCidadeFile = ComandoCSV.class.getResourceAsStream(caminhoArquivo);
        return new Scanner(resourceCidadeFile, "UTF-8").useDelimiter("\\n");
    }
}
