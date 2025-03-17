package implementations;

import interfaces.Mapa;

import java.util.LinkedList;
import java.util.Objects;

public class TabelaHashComListaEncadeada implements Mapa {

    private int tamanho;
    private int capacidade;
    private LinkedList<Nodo> tabela[];

    public TabelaHashComListaEncadeada(){
        this.tamanho = 0;
        this.capacidade = 100;
        this.tabela = new LinkedList[capacidade];
    }

    public int obterPosicao(int chave){return chave % this.capacidade;}

    @Override
    public void adicionar(int chave, int valor) {
        int posicao = obterPosicao(chave);
        if(contemChave(chave)){
            for(var nodo: tabela[posicao]){
                if(Objects.equals(nodo.chave(), chave)){
                    tabela[posicao].remove(nodo);
                }
            }
        }
        if(tabela[posicao] == null){
            tabela[posicao] = new LinkedList<>();
        }
        tabela[posicao].add(new Nodo(chave, valor));
        tamanho++;
    }

    @Override
    public int remover(int chave) {
        int posicao = obterPosicao(chave);
        tamanho--;
        if(!contemChave(chave))throw new RuntimeException("Chave inválida.");
        for(var nodo: tabela[posicao]){
            if(Objects.equals(nodo.chave, chave)){
                tabela[posicao].remove(nodo);
                return nodo.valor();
            }
        }
        return -1;
    }

    @Override
    public int obter(int chave) {
        int posicao = obterPosicao(chave);
        if(!contemChave(chave)) throw new RuntimeException("Chave inválida");
        for(var nodo: tabela[posicao]){
            if(Objects.equals(nodo.chave(), chave)){
                return nodo.valor();
            }
        }
        return -1;
    }

    @Override
    public boolean contemChave(int chave) {
        int posicao = obterPosicao(chave);
        if(tabela[posicao] == null) return false;
        for(var nodo: tabela[posicao]){
            if(Objects.equals(nodo.chave, chave)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public boolean estaVazio() {
        return this.tamanho == 0;
    }

    record Nodo(int chave, int valor){}
}
