package interfaces;

public interface FilaDePrioridade {

    public void adicionar(int valor, int prioridade);

    public int remover();

    public int obter();

    public int tamanho();

}
