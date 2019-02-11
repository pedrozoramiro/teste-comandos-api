package br.com.teste.comandos.api.commandos.csv;


import br.com.teste.comandos.api.commandos.core.dados.FonteDados;

import java.util.function.Consumer;

public class FakeFonteDados implements FonteDados {
    String dados = "1100015,RO,Alta Floresta D'Oeste,,-61.9998238963,-11.9355403048,Alta Floresta D'Oeste,,Cacoal,Leste Rondoniense\n" +
            "1100023,RO,Ariquemes,,-63.033269278,-9.9084628666,Ariquemes,,Ariquemes,Leste Rondoniense\n" +
            "1100031,RO,Cabixi,,-60.5443135812,-13.4997634597,Cabixi,,Colorado do Oeste,Leste Rondoniense\n" +
            "1100049,RO,Cacoal,,-61.4429442118,-11.4338650287,Cacoal,,Cacoal,Leste Rondoniense\n" +
            "1100056,SC,Cerejeiras,,-60.8184261647,-13.195033032,Cerejeiras,,Colorado do Oeste,Leste Rondoniense\n" +
            "1100064,SC,Colorado do Oeste,,-60.5550674631,-13.1305638415,Colorado do Oeste,,Colorado do Oeste,Leste Rondoniense\n" +
            "1100072,PR,Corumbiara,,-60.9487011707,-12.9975202365,Corumbiara,,Colorado do Oeste,Leste Rondoniense\n" +
            "1100080,PR,Costa Marques,,-64.2316539391,-12.4360138777,Costa Marques,,Guajará-Mirim,Madeira-Guaporé\n" +
            "1100098,CE,Espigão D'Oeste,,-61.0201731133,-11.5285546333,Espigao D'Oeste,,Cacoal,Leste Rondoniense\n" +
            "1100106,CE,Guajará-Mirim,,-65.3239518197,-10.7738837407,Guajara-Mirim,,Guajará-Mirim,Madeira-Guaporé";

    @Override
    public void lerArquivo(Consumer<String[]> eventoLinhas) {
        lerArquivo(null, eventoLinhas);
    }

    @Override
    public void lerArquivo(Consumer<String[]> eventoHeader, Consumer<String[]> eventoLinhas) {
        if (eventoHeader != null)
            eventoHeader.accept(getHeader());

        for (String linha : dados.split("\\n")) {
            String[] campos = linha.split(",");
            eventoLinhas.accept(campos);
        }
    }

    @Override
    public String[] getHeader() {
        return new String[]{"ibge_id", "uf", "name", "capital", "lon", "lat", "no_accents", "alternative_names", "microregion", "mesoregion" };
    }

    @Override
    public Integer getIndiceCampo(String nomeDoCampo) {
        return 1;
    }
}