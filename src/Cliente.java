import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable {

    public Cliente(String nome, String telefone, String email) {
        super(nome, telefone, email);
    }

    public Cliente(String nome, String telefone, String email, String cpf) {
        super(nome, telefone, cpf, email);
    }

    // public String getEmail() {
    //     return super.email;
    // }
}
