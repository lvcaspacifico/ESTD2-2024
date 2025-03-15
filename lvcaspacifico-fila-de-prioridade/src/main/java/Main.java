import implementations.FilaDePrioridadeNaoOrdenada;

public class Main {

    public static void main(String args[]){
        System.out.println("Rodando...");

        FilaDePrioridadeNaoOrdenada fila = new FilaDePrioridadeNaoOrdenada();

        fila.adicionar(10, 1);
        fila.adicionar(1000, 25);
        fila.adicionar(10, 15);
        fila.adicionar(100, 10);

        System.out.println("Obtive: " + fila.obter());;

    }

}
