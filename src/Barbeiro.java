import java.io.Serializable;

public class Barbeiro extends Pessoa implements Serializable {
    private String especialidade;

    public Barbeiro(String nome, String telefone, String especialidade) {
        super(nome, telefone);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}