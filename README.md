# Sistema de Agendamentos para Barbearia

## Visão Geral do Projeto

Este repositório contém o código-fonte para um sistema de agendamentos desenvolvido para uma barbearia. Abaixo está uma análise detalhada das classes e como cada especificação do projeto é atendida.

### 1. Sistema aplicável em contexto real
O sistema desenvolvido é um sistema de agendamentos para uma barbearia, um exemplo aplicável em um contexto real.

### 2. Classes do Projeto
O projeto contém as seguintes classes:
- `Main`
- `Agenda`
- `Agendamento`
- `Barbeiro`
- `Cliente`
- `Dados`
- `Pessoa`
- `Servico`
- `Util`

### 3. Composição de Classe
- A classe `Agenda` contém uma lista de objetos `Agendamento`.
- A classe `Agendamento` contém objetos das classes `Cliente`, `Barbeiro` e `Servico`.

### 4. Herança
- As classes `Barbeiro` e `Cliente` herdam da classe `Pessoa`.

### 5. Polimorfismo
- Pode ser aplicado com a classe `Pessoa`, onde `Barbeiro` e `Cliente` são subclasses e podem ser tratadas como `Pessoa`.

### 6. Sobrecarga de Métodos
A classe `Cliente` possui dois construtores sobrecarregados:
```java
public Cliente(String nome, String telefone, String email) {
    super(nome, telefone);
    this.email = email;
}

public Cliente(String nome, String telefone, String email, String cpf) {
    super(nome, telefone, cpf);
    this.email = email;
}
```

### 7. Método static
- A classe `Util` contém métodos estáticos `salvarDados` e `carregarDados`.

### 8. Persistência de Informações
- A classe `Util` cuida da serialização e desserialização dos dados com os métodos `salvarDados` e `carregarDados`.

## Fluxograma

### Fluxo Principal do Sistema

1. **Início**
2. **Exibir Menu**
   - 1. Cadastrar Barbeiro
   - 2. Listar Barbeiros
   - 3. Adicionar Agendamento
   - 4. Listar Agendamentos
   - 5. Salvar Dados
   - 6. Carregar Dados
   - 7. Sair
3. **Processar Escolha do Usuário**
   - **Cadastrar Barbeiro**
     - Entrada de dados (nome, telefone, especialidade, CPF)
     - Validar dados
     - Adicionar à lista de barbeiros
   - **Listar Barbeiros**
     - Exibir lista de barbeiros cadastrados
   - **Adicionar Agendamento**
     - Verificar se há barbeiros cadastrados
     - Entrada de dados (cliente, barbeiro, data/hora, descrição do serviço, preço)
     - Validar dados
     - Adicionar agendamento à agenda
   - **Listar Agendamentos**
     - Exibir lista de agendamentos
   - **Salvar Dados**
     - Serializar dados (agenda e barbeiros) e salvar em arquivo
   - **Carregar Dados**
     - Desserializar dados do arquivo e carregar na aplicação
   - **Sair**
     - Perguntar se deseja salvar os dados antes de sair
4. **Fim**

### Exemplos de Fluxograma

#### Menu Principal
```plaintext
Inicio
    ↓
Exibir Menu
    ↓
Escolha do Usuário
    ↓
[1] Cadastrar Barbeiro → Cadastrar Barbeiro
    ↓
[2] Listar Barbeiros → Listar Barbeiros
    ↓
[3] Adicionar Agendamento → Adicionar Agendamento
    ↓
[4] Listar Agendamentos → Listar Agendamentos
    ↓
[5] Salvar Dados → Salvar Dados
    ↓
[6] Carregar Dados → Carregar Dados
    ↓
[7] Sair → Sair
```

#### Cadastrar Barbeiro
```plaintext
Cadastrar Barbeiro
    ↓
Entrada de Dados
    ↓
Validar Dados
    ↓
Adicionar à Lista de Barbeiros
    ↓
Fim
```

#### Adicionar Agendamento
```plaintext
Adicionar Agendamento
    ↓
Verificar se há barbeiros cadastrados
    ↓
Entrada de Dados
    ↓
Validar Dados
    ↓
Adicionar Agendamento à Agenda
    ↓
Fim
```

## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


