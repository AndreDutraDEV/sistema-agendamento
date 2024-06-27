import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("João", "12345678", "joao@example.com");
        Barbeiro barbeiro1 = new Barbeiro("Carlos", "87654321", "Corte de cabelo");
        Servico servico1 = new Servico("Corte de Cabelo", 50.0);
        
        Agendamento agendamento1 = new Agendamento(cliente1, barbeiro1, servico1, LocalDateTime.now());

        Agenda agenda = new Agenda();
        agenda.adicionarAgendamento(agendamento1);

        try {
            Util.salvarAgenda(agenda, "agenda.ser");
            Agenda agendaCarregada = Util.carregarAgenda("agenda.ser");
            agendaCarregada.listarAgendamentos();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
