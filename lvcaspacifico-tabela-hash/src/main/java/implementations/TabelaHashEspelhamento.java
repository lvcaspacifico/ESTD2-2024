package implementations;

import interfaces.Mapa;

public class TabelaHashEspelhamento implements Mapa {

    private int tamanho;
    private int capacidade;
    private Integer[] tabela;

    public TabelaHashEspelhamento(){
        this.tamanho = 0;
        this.capacidade = 100;
        this.tabela = new Integer[this.capacidade];
    }

    @Override
    public void adicionar(int chave, int valor) {
        if(chave < this.capacidade){
            this.tabela[chave] = valor;
            tamanho++;
        }
    }

    @Override
    public int remover(int chave) {
        if(!contemChave(chave))throw new RuntimeException("Chave não encontrada");
        var valor = this.tabela[chave];
        this.tabela[chave] = null;
        tamanho--;
        return valor;
    }

    @Override
    public int obter(int chave) {
       if(!contemChave(chave))throw new RuntimeException(("Chave não encontrada"));
        return tabela[chave];
    }

    @Override
    public boolean contemChave(int chave) {
        return tabela[chave] != null;
    }

    @Override
    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public boolean estaVazio() {
        return this.tamanho == 0;
    }

    public void mostrarTabela(){
        for(int i = 0; i < this.capacidade; i++){
            if(this.tabela[i] != null){
                System.out.println("Chave: "+i+" Valor: "+this.tabela[i]);
            }
        }
    }
}
