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

    public boolean existeConflitoAgendamento(Barbeiro barbeiro, LocalDateTime dataHora) {
        for (Agendamento agendamento : agendamentos) {
            if (agendamento.getBarbeiro().equals(barbeiro) && agendamento.getDataHora().isEqual(dataHora)) {
                return true;
            }
        }
        return false;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void listarAgendamentos() {
        for (Agendamento agendamento : agendamentos) {
            System.out.println(agendamento.getCliente().getNome() + " - " + agendamento.getServico().getDescricao() + " com " + agendamento.getBarbeiro().getNome() + " em " + agendamento.getDataHora());
        }
    }
}
