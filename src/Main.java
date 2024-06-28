import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        List<Barbeiro> barbeiros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Barbeiro");
            System.out.println("2. Listar Barbeiros");
            System.out.println("3. Adicionar Agendamento");
            System.out.println("4. Listar Agendamentos");
            System.out.println("5. Salvar Dados");
            System.out.println("6. Carregar Dados");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Barbeiro (ou -1 para cancelar): ");
                    String nomeBarbeiro = scanner.nextLine();
                    if (nomeBarbeiro.equals("-1")) break;

                    System.out.print("Telefone do Barbeiro (ou -1 para cancelar): ");
                    String telefoneBarbeiro = scanner.nextLine();
                    if (telefoneBarbeiro.equals("-1")) break;

                    System.out.print("Especialidade do Barbeiro (ou -1 para cancelar): ");
                    String especialidadeBarbeiro = scanner.nextLine();
                    if (especialidadeBarbeiro.equals("-1")) break;

                    Barbeiro barbeiro = new Barbeiro(nomeBarbeiro, telefoneBarbeiro, especialidadeBarbeiro);
                    barbeiros.add(barbeiro);
                    break;
                case 2:
                    if (barbeiros.isEmpty()) {
                        System.out.println("Nenhum barbeiro cadastrado.");
                    } else {
                        System.out.println("Barbeiros cadastrados:");
                        for (Barbeiro b : barbeiros) {
                            System.out.println("Nome: " + b.getNome() + ", Telefone: " + b.getTelefone() + ", Especialidade: " + b.getEspecialidade());
                        }
                    }
                    break;
                case 3:
                    if (barbeiros.isEmpty()) {
                        System.out.println("Nenhum barbeiro cadastrado. Cadastre um barbeiro primeiro.");
                        break;
                    }

                    System.out.print("Nome do Cliente (ou -1 para cancelar): ");
                    String nomeCliente = scanner.nextLine();
                    if (nomeCliente.equals("-1")) break;

                    System.out.print("Telefone do Cliente (ou -1 para cancelar): ");
                    String telefoneCliente = scanner.nextLine();
                    if (telefoneCliente.equals("-1")) break;

                    System.out.print("Email do Cliente (ou -1 para cancelar): ");
                    String emailCliente = scanner.nextLine();
                    if (emailCliente.equals("-1")) break;
                    Cliente cliente = new Cliente(nomeCliente, telefoneCliente, emailCliente);

                    System.out.println("Escolha um Barbeiro (ou digite -1 para cancelar):");
                    for (int i = 0; i < barbeiros.size(); i++) {
                        System.out.println((i + 1) + ". " + barbeiros.get(i).getNome());
                    }
                    int escolhaBarbeiro = scanner.nextInt();
                    if (escolhaBarbeiro == -1) break;
                    scanner.nextLine(); // Consumir a nova linha
                    Barbeiro barbeiroEscolhido = barbeiros.get(escolhaBarbeiro - 1);

                    LocalDateTime dataHora = null;
                    while (true) {
                        try {
                            System.out.print("Data do Serviço (dd/MM) (ou -1 para cancelar): ");
                            String data = scanner.nextLine();
                            if (data.equals("-1")) break;
                            System.out.print("Hora do Serviço (HH:mm) (ou -1 para cancelar): ");
                            String hora = scanner.nextLine();
                            if (hora.equals("-1")) break;

                            dataHora = LocalDateTime.now()
                                    .withMonth(Integer.parseInt(data.split("/")[1]))
                                    .withDayOfMonth(Integer.parseInt(data.split("/")[0]))
                                    .withHour(Integer.parseInt(hora.split(":")[0]))
                                    .withMinute(Integer.parseInt(hora.split(":")[1]))
                                    .withSecond(0)
                                    .withNano(0);

                            if (agenda.existeConflitoAgendamento(barbeiroEscolhido, dataHora)) {
                                System.out.println("Já existe um agendamento para este barbeiro neste horário.");
                                dataHora = null;
                            } else {
                                break;
                            }
                        } catch (DateTimeParseException | NumberFormatException e) {
                            System.out.println("Data ou hora inválida. Tente novamente.");
                        }
                    }
                    if (dataHora == null) break;

                    System.out.print("Descrição do Serviço (ou -1 para cancelar): ");
                    String descricaoServico = scanner.nextLine();
                    if (descricaoServico.equals("-1")) break;

                    System.out.print("Preço do Serviço (ou -1 para cancelar): ");
                    double precoServico = scanner.nextDouble();
                    if (precoServico == -1) break;
                    scanner.nextLine(); // Consumir a nova linha
                    Servico servico = new Servico(descricaoServico, precoServico);

                    Agendamento agendamento = new Agendamento(cliente, barbeiroEscolhido, servico, dataHora);
                    agenda.adicionarAgendamento(agendamento);
                    break;
                case 4:
                    agenda.listarAgendamentos();
                    break;
                case 5:
                    try {
                        Dados dados = new Dados(agenda, barbeiros);
                        Util.salvarDados(dados, "dados.ser");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    try {
                        Dados dados = Util.carregarDados("dados.ser");
                        agenda = dados.getAgenda();
                        barbeiros = dados.getBarbeiros();
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    int finalizar = 0;

                    do {
                        System.out.print("Deseja salvar os dados? (S para sim; N para não; C para cancelar): ");
                        String desejaSalvar = scanner.nextLine().toUpperCase();

                        if (desejaSalvar.equals("S")) {
                            try {
                                Dados dados = new Dados(agenda, barbeiros);
                                Util.salvarDados(dados, "dados.ser");
                                finalizar = 1;
                            } catch (IOException e) {
                                e.printStackTrace();
                                System.out.print("Houve um erro ao tentar salvar. Processo não finalizado para proteger os dados.");
                            }
                        } else if (desejaSalvar.equals("N")) {
                            finalizar = 1;
                        } else if (desejaSalvar.equals("C")) {
                            break;
                        } else {
                            System.out.println("Opção inválida. Tente novamente.");
                        }
                    } while (finalizar == 0);

                    if (finalizar == 1) {
                        scanner.close();
                        System.exit(0);
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
