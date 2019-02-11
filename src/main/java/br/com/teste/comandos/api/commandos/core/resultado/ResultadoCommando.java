package br.com.teste.comandos.api.commandos.core.resultado;

public class ResultadoCommando<T> {
    private T dados;

    public ResultadoCommando(T dados) {
        this.dados = dados;
    }

    public T getDados() {
        return dados;
    }

    public void escreveNoConsole(){
        System.out.println(dados);
    }
}
