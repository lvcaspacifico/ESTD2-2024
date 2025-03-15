package implementations;
import lombok.Getter;
import lombok.Setter;

// O professor usou um Record, preferi usar uma Class com Lombok só pra diferenciar
public class Nodo {

    @Setter
    @Getter
    public int valor;
    @Setter
    @Getter
    public int prioridade;

}
