import java.io.Serializable;
import java.util.List;

public class Dados implements Serializable {
    private Agenda agenda;
    private List<Barbeiro> barbeiros;

    public Dados(Agenda agenda, List<Barbeiro> barbeiros) {
        this.agenda = agenda;
        this.barbeiros = barbeiros;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public List<Barbeiro> getBarbeiros() {
        return barbeiros;
    }
}
