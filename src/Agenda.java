import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Agenda implements Serializable {
    private List<Agendamento> agendamentos;

    public Agenda() {
        agendamentos = new ArrayList<>();
    }

    public void adicionarAgendamento(Agendamento agendamento) {
        agendamentos.add(agendamento);
    }

    // Sobrecarga de método
    public void adicionarAgendamento(Cliente cliente, Barbeiro barbeiro, Servico servico, LocalDateTime dataHora) {
        Agendamento agendamento = new Agendamento(cliente, barbeiro, servico, dataHora);
        agendamentos.add(agendamento);
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    // Polimorfismo - Método que pode ser sobrescrito
    public void listarAgendamentos() {
        for (Agendamento agendamento : agendamentos) {
            System.out.println(agendamento.getCliente().getNome() + " - " + agendamento.getServico().getDescricao() + " com " + agendamento.getBarbeiro().getNome() + " em " + agendamento.getDataHora());
        }
    }
}
