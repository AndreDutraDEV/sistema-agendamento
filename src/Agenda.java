import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM");
        DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm");

        if (agendamentos.size() == 0) {
            System.out.println("\nA lista de agendamentos está vazia!\n");
        } else {
            for (Agendamento agendamento : agendamentos) {
                String data = agendamento.getDataHora().format(dataFormatter);
                String hora = agendamento.getDataHora().format(horaFormatter);
                System.out.println("\n\n----------------------------------");
                System.out.println("Cliente: " + agendamento.getCliente().getNome());
                System.out.println("Serviço: " + agendamento.getServico().getDescricao());
                System.out.println("Barbeiro: " + agendamento.getBarbeiro().getNome());
                System.out.println("Data: " + data);
                System.out.println("Hora: " + hora);
                System.out.println("Preço: " + agendamento.getServico().getPreco());
                System.out.println("\n\n----------------------------------");
            }
        }

    }
}
