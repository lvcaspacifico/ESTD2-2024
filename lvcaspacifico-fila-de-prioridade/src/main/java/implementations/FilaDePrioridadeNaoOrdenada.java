package implementations;
import interfaces.FilaDePrioridade;
import java.util.ArrayList;
import java.util.List;

public class FilaDePrioridadeNaoOrdenada implements FilaDePrioridade {
    // List para poder trocar a implementação no futuro
    private List<Nodo> lista;

    public FilaDePrioridadeNaoOrdenada(){
        lista = new ArrayList<>(); // o Compilador deduz o tipo em <> baseado na declaração
    }

    // O(1) -> adiciona no final
    @Override
    public void adicionar(int valor, int prioridade) {
        Nodo nodo = new Nodo();
        nodo.setPrioridade(prioridade);
        nodo.setValor(valor);
        lista.add(nodo);
    }

    // O(n) -> verifica tudo pra achar a maior prioridade
    @Override
    public int remover() {
        if(lista.size() < 1){throw new  RuntimeException("Lista está vazia.");}
        // index maior prioridade
        int indexMP = 0;
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getPrioridade() > lista.get(indexMP).getPrioridade()){
                indexMP = i;
            }
        }
        Nodo nodo = lista.remove(indexMP);
        return nodo.getValor();
    }

    @Override
    public int obter() {
        if(lista.size() < 1){throw new  RuntimeException("Lista está vazia.");}
        // index maior prioridade
        int indexMP = 0;
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getPrioridade() > lista.get(indexMP).getPrioridade()){
                indexMP = i;
            }
        }
        Nodo nodo = lista.get(indexMP);
        return nodo.getValor();
    }

    // O(1)
    @Override
    public int tamanho() { return lista.size(); }

}
