import java.io.IOException;
import java.time.LocalDateTime;
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
                    String nomeBarbeiro = null;
                    while (true) {
                        System.out.print("Nome do Barbeiro (ou -1 para cancelar): ");
                        nomeBarbeiro = scanner.nextLine();
                        if (nomeBarbeiro.equals("-1")) break;
                        if (!nomeBarbeiro.matches("[A-Za-z ]+")) {
                            System.out.println("Nome inválido. Digite novamente.");
                        } else {
                            break;
                        }
                    }
                    if (nomeBarbeiro.equals("-1")) break;

                    String telefoneBarbeiro = null;
                    while (true) {
                        System.out.print("Telefone do Barbeiro (ou -1 para cancelar): ");
                        telefoneBarbeiro = scanner.nextLine();
                        if (telefoneBarbeiro.equals("-1")) break;
                        if (!telefoneBarbeiro.matches("\\d{11}")) {
                            System.out.println("Telefone inválido. Digite novamente.");
                        } else {
                            telefoneBarbeiro = formatarTelefone(telefoneBarbeiro);
                            break;
                        }
                    }
                    if (telefoneBarbeiro.equals("-1")) break;

                    String especialidadeBarbeiro = null;
                    while (true) {
                        System.out.print("Especialidade do Barbeiro (ou -1 para cancelar): ");
                        especialidadeBarbeiro = scanner.nextLine();
                        if (especialidadeBarbeiro.equals("-1")) break;
                        if (!especialidadeBarbeiro.matches("[A-Za-z ]+")) {
                            System.out.println("Especialidade inválida. Digite novamente.");
                        } else {
                            break;
                        }
                    }
                    if (especialidadeBarbeiro.equals("-1")) break;

                    String email = null;
                    while (true) {
                        System.out.print("Digite o Email do Barbeiro (ou -1 para cancelar): ");
                        email = scanner.nextLine();
                        if (email.equals("-1")) break;
                        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                            System.out.println("Email inválido. Digite novamente.");
                    String cpfBarbeiro = null;
                    while (true) {
                        System.out.print("Cpf do Barbeiro [apenas os números] (ou -1 para cancelar): ");
                        cpfBarbeiro = scanner.nextLine();
                        if (cpfBarbeiro.equals("-1")) break;
                        if (!cpfBarbeiro.matches("\\d{11}")) {
                            System.out.println("Cpf inválido. Digite novamente.");
                        } else {
                            break;
                        }
                    }
                    if (cpfBarbeiro.equals("-1")) break;
                    
                    Barbeiro barbeiro = new Barbeiro(nomeBarbeiro, telefoneBarbeiro, especialidadeBarbeiro, cpfBarbeiro,email);
                    barbeiros.add(barbeiro);
                    
                    System.out.println("\nBarbeiro cadastrado com sucesso!\n");

                    break;
                case 2:
                    if (barbeiros.isEmpty()) {
                        System.out.println("\nNenhum barbeiro cadastrado.\n");
                    } else {
                        System.out.println("Barbeiros cadastrados:");
                        for (Barbeiro b : barbeiros) {
                            System.out.println("Nome: " + b.getNome() + ", Telefone: " + b.getTelefone() + ", Especialidade: " + b.getEspecialidade());
                        }
                        System.out.println("\n\n");
                    }
                    break;
                case 3:
                    if (barbeiros.isEmpty()) {
                        System.out.println("Nenhum barbeiro cadastrado. Cadastre um barbeiro primeiro.");
                        break;
                    }

                    String nomeCliente = null;
                    while (true) {
                        System.out.print("Nome do Cliente (ou -1 para cancelar): ");
                        nomeCliente = scanner.nextLine();
                        if (nomeCliente.equals("-1")) break;
                        if (!nomeCliente.matches("[A-Za-z ]+")) {
                            System.out.println("Nome inválido. Digite novamente.");
                        } else {
                            break;
                        }
                    }
                    if (nomeCliente.equals("-1")) break;

                    String telefoneCliente = null;
                    while (true) {
                        System.out.print("Telefone do Cliente (ou -1 para cancelar): ");
                        telefoneCliente = scanner.nextLine();
                        if (telefoneCliente.equals("-1")) break;
                        if (!telefoneCliente.matches("\\d{11}")) {
                            System.out.println("Telefone inválido. Digite novamente.");
                        } else {
                            telefoneCliente = formatarTelefone(telefoneCliente);
                            break;
                        }
                    }
                    if (telefoneCliente.equals("-1")) break;

                    String emailCliente = null;
                    while (true) {
                        System.out.print("Email do Cliente (ou -1 para cancelar): ");
                        emailCliente = scanner.nextLine();
                        if (emailCliente.equals("-1")) break;
                        if (!emailCliente.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                            System.out.println("Email inválido. Digite novamente.");
                        } else {
                            break;
                        }
                    }
                    if (emailCliente.equals("-1")) break;
                    
                    String cpfCliente = null;
                    while (true) {
                        System.out.print("Cpf do Cliente [apenas os números] (ou -1 para não preencher este dado): ");
                        cpfCliente = scanner.nextLine();
                        if (cpfCliente.equals("-1")) break;
                        if (!cpfCliente.matches("\\d{11}")) {
                            System.out.println("Cpf inválido. Digite novamente.");
                        } else {
                            break;
                        }
                    }

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

                    System.out.println("\nAgendamento criado com sucesso!\n");
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
                        System.out.println("\nDados carregados com sucesso!\n");
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

    private static String formatarTelefone(String telefone) {
        return String.format("(%s) %s-%s", telefone.substring(0, 2), telefone.substring(2, 7), telefone.substring(7));
    }
}
