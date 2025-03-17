package implementations;

public class Pessoa {
    private String cpf;
    private String nome;
    private String sobrenome;
    private short idade;

    public Pessoa(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public short getIdade() {
        return idade;
    }
    public void setIdade(short idade) {
        this.idade = idade;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(this.cpf.substring(0, 1));
    }

    @Override
    public boolean equals(Object obj) {
        Pessoa that = (Pessoa) obj;
        return this.cpf.equals(that.cpf);
    }

    @Override
    public String toString() {
        return "Pessoa [cpf=" + cpf + "]";
    }
}
