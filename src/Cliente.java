import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable {

    public Cliente(String nome, String telefone, String email) {
        super(nome, telefone, email);
    }


   
}
