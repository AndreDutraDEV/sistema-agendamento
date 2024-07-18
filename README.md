# Projeto de Sistema de Agendamentos para Barbearia - Programação 2 - UPE Sistemas De Informação

<!-- //////////////////////////////////////////////////////////////////////////////////////// -->

## Visão Geral do Projeto

Este repositório contém o código-fonte para um sistema de agendamentos desenvolvido para uma barbearia. Abaixo está uma análise detalhada das classes e como cada especificação do projeto é atendida.

### 1. Sistema aplicável em contexto real

**Descrição:**
O sistema desenvolvido é um sistema de agendamentos para uma barbearia, um exemplo aplicável em um contexto real.

**Presente em:**
Todo o projeto, especialmente na classe `Main`, onde é implementada a lógica para gerenciar barbeiros, clientes e agendamentos.

```java
public class Main {
    public static void main(String[] args) {
        // Implementação do sistema de agendamentos para a barbearia
    }
}
```

### 2. Pelo menos 4 classes distintas

**Classes:**
- `Agenda`
- `Agendamento`
- `Barbeiro`
- `Cliente`
- `Pessoa`
- `Servico`
- `Dados`
- `Util`

### 3. Utilização de composição de classe

**Descrição:**
Uma classe é tratada como um atributo de outra classe.

**Presente em:**
- `Agenda` tem uma lista de `Agendamento`
- `Agendamento` tem `Cliente`, `Barbeiro` e `Servico` como atributos

```java
public class Agenda implements Serializable {
    private List<Agendamento> agendamentos;
}

public class Agendamento implements Serializable {
    private Cliente cliente;
    private Barbeiro barbeiro;
    private Servico servico;
}
```

### 4. Aplicação de herança

**Descrição:**
Criar uma classe pai e filha pelo menos.

**Presente em:**
- `Barbeiro` e `Cliente` herdam de `Pessoa`

```java
public class Barbeiro extends Pessoa {
    // Implementação específica de Barbeiro
}

public class Cliente extends Pessoa {
    // Implementação específica de Cliente
}
```

### 5. Aplicação de polimorfismo

**Descrição:**
Aplicar polimorfismo pelo menos uma vez.

**Presente em:**
O método `listarAgendamentos` na classe `Agenda` utiliza o método `getNome()` que é polimórfico, pois pode se referir a `Cliente` ou `Barbeiro`.

```java
public void listarAgendamentos() {
    for (Agendamento agendamento : agendamentos) {
        System.out.println("Cliente: " + agendamento.getCliente().getNome());
        System.out.println("Barbeiro: " + agendamento.getBarbeiro().getNome());
    }
}
```

### 6. Sobrecarga de métodos

**Descrição:**
Aplicar sobrecarga de métodos pelo menos uma vez.

**Presente em:**
A classe `Pessoa` tem dois construtores sobrecarregados.

```java
public class Pessoa implements Serializable {
    public Pessoa(String nome, String telefone, String email) {
        // Implementação
    }

    public Pessoa(String nome, String telefone, String cpf, String email) {
        // Implementação
    }
}
```

### 7. Método static

**Descrição:**
Criar método static pelo menos uma vez.

**Presente em:**
Métodos `salvarDados` e `carregarDados` na classe `Util`.

```java
public class Util {
    public static void salvarDados(Dados dados, String arquivo) throws IOException {
        // Implementação
    }

    public static Dados carregarDados(String arquivo) throws IOException, ClassNotFoundException {
        // Implementação
    }
}
```

### 8. Persistência de informações por serialização

**Descrição:**
Criar fluxo para persistência de informações da aplicação.

**Presente em:**
Métodos `salvarDados` e `carregarDados` na classe `Util`.

```java
public class Util {
    public static void salvarDados(Dados dados, String arquivo) throws IOException {
        // Implementação
    }

    public static Dados carregarDados(String arquivo) throws IOException, ClassNotFoundException {
        // Implementação
    }
}
```

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

### Resumo

Cada especificação do projeto está claramente implementada e pode ser encontrada nas classes e métodos descritos acima. Isso mostra um uso consistente de conceitos de programação orientada a objetos, como herança, composição, polimorfismo, sobrecarga de métodos, métodos estáticos e serialização.

## Créditos

Atividade proposta pelo professor [Domingos Santos](https://github.com/domingos108)  da Universidade de Pernambuco.

## Agradecimentos

Agradeço à UPE e ao professor da disciplina por proporcionarem esses desafios que contribuem para o nosso aprendizado em programação. Se você é um colega de classe, não hesite em compartilhar suas soluções!

*Divirta-se explorando o mundo da programação! 🚀*
