package implementations;

import interfaces.FilaDePrioridade;

public class MaxHeapComArranjo implements FilaDePrioridade {

    // Array de Nodo
    private Nodo heap[];
    private int tamanho;

    public MaxHeapComArranjo(){
        heap = new Nodo[8];
    }

    @Override
    public void adicionar(int valor, int prioridade) {
        if(tamanho == heap.length) throw new RuntimeException("Heap está cheio.");
        Nodo nodo = new Nodo();
        nodo.setPrioridade(prioridade);
        nodo.setValor(valor);
        heap[tamanho] = nodo;
        corrigirDeBaixoParaCima(tamanho);
        tamanho++;
    }

    @Override
    public int remover() {
        if(tamanho < 1) throw new RuntimeException("Heap está vazio.");
        Nodo removido = heap[0];
        heap[0] = heap[tamanho -1];
        heap[tamanho-1] = null;
        tamanho--;
        corrigirDeCimaParaBaixo(0);
        return removido.getValor();
    }

    @Override
    public int obter() {
        if(tamanho < 1) throw new RuntimeException("Heap está vazio.");
        return heap[0].getValor();
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    public int esquerda(int posicao){
        // 2i
        return 2 * posicao;
    }

    public int direita(int posicao){
        // 2i+1
        return 2 * posicao + 1;
    }

    public int pai(int posicao){
        // i
        return (int)Math.floor(posicao/2.0);
    }

    public void corrigirDeBaixoParaCima(int posicao){
        if(posicao == 0) return;

        // Se o pai for menor que o filho
        if(heap[pai(posicao)].getPrioridade() < heap[posicao].getPrioridade()){
            var aux = heap[pai(posicao)];
            heap[pai(posicao)] = heap[posicao];
            heap[posicao] = aux;
            // Chamada recursiva
            corrigirDeBaixoParaCima(pai(posicao));
        }
    }

    public void  corrigirDeCimaParaBaixo(int posicao){
        if(posicao >= tamanho) return;
        // Conferindo se é < filho da esquerda
        int maior = posicao;
        if(esquerda(posicao) < tamanho && heap[esquerda(posicao)].getPrioridade() > heap[posicao].getPrioridade()){
            maior = esquerda(posicao);
        }
        // Conferindo se é < filho da direita
        if(direita(posicao) < tamanho && heap[direita(posicao)].getPrioridade() > heap[posicao].getPrioridade()){
            maior = direita(posicao);
        }
        // Se o maior é um dos filhos
        if(maior != posicao){
            // Troca
            var aux = heap[maior];
            heap[maior] = heap[posicao];
            heap[posicao] = aux;
            corrigirDeCimaParaBaixo(maior);
        }
    }


}
