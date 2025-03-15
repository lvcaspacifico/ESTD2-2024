import implementations.FilaDePrioridadeNaoOrdenada;
import implementations.MaxHeapComArranjo;

public class Main {

    public static void main(String args[]){
        System.out.println("Rodando...");

        MaxHeapComArranjo maxheap = new MaxHeapComArranjo();

        maxheap.adicionar(10, 10);
        maxheap.adicionar(20, 20);
        maxheap.adicionar(30, 30);

        maxheap.exibirArranjo();

    }

}
