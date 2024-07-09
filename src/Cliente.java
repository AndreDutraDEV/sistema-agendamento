import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable {
    private String email;

    public Cliente(String nome, String telefone, String email) {
        super(nome, telefone);
        this.email = email;
    }

    public Cliente(String nome, String telefone, String email, String cpf) {
        super(nome, telefone, cpf);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
