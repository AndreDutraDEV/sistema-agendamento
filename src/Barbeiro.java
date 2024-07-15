import java.io.Serializable;

public class Barbeiro extends Pessoa implements Serializable {
    private String especialidade;

    public Barbeiro(String nome, String telefone, String especialidade, String email) {
        super(nome, telefone, email);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public void setEmail(String email) {
        if (email.endsWith("@barbearia.com")) {
            setEmail(email);
        } else {
            throw new IllegalArgumentException("Email deve terminar com @barbearia.com");
        }
    }
}
