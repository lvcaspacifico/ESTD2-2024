import implementations.TabelaHashEspelhamento;

public class Main {

    public static void main(String args[]){
        System.out.println("Rodando...");

        // Tabela Hash que não trata colisões
        TabelaHashEspelhamento tabela = new TabelaHashEspelhamento();


        tabela.adicionar(0, 30);
        tabela.adicionar(1, 40);
        tabela.adicionar(2, 50);
        tabela.adicionar(3, 60);
        tabela.adicionar(4, 70);
        tabela.adicionar(5, 80);
        tabela.adicionar(6, 90);

        tabela.mostrarTabela();

    }
}
