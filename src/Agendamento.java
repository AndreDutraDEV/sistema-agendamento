import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Agendamento implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Cliente cliente;
    private Barbeiro barbeiro;
    private Servico servico;
    private transient LocalDateTime dataHora; // Use transient to avoid direct serialization

    public Agendamento(Cliente cliente, Barbeiro barbeiro, Servico servico, LocalDateTime dataHora) {
        this.cliente = cliente;
        this.barbeiro = barbeiro;
        this.servico = servico;
        this.dataHora = dataHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    // Custom serialization logic
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeUTF(dataHora.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        this.dataHora = LocalDateTime.parse(ois.readUTF(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
