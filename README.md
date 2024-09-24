
# Sistema de Gerenciamento de Agência de Viagens

Este sistema foi desenvolvido para gerenciar turistas, pacotes de viagem e pagamentos em uma agência de viagens. Ele oferece funcionalidades para cadastrar, atualizar, remover e listar turistas, pacotes de viagem e pagamentos, facilitando o dia a dia dos funcionários da agência.

## Funcionalidades Principais

1. **Gerenciamento de Turistas**: Cadastro, consulta, atualização e remoção de turistas.
2. **Gerenciamento de Pacotes de Viagem**: Associar pacotes de viagem a turistas e gerenciar os detalhes de cada pacote.
3. **Gerenciamento de Pagamentos**: Registro e consulta de pagamentos feitos pelos turistas, categorizando-os entre pagos e pendentes.

---

## Fluxo de Uso

O fluxo do sistema é organizado através de um menu interativo que permite ao usuário navegar entre as opções de gerenciamento. Abaixo está uma descrição do fluxo de uso do sistema.

### 1. Menu Principal

Ao iniciar o sistema, o usuário será apresentado ao **Menu Principal**, onde poderá escolher entre as opções:

```
=== Menu Principal ===
1. Gerenciar Turistas e Pacotes de Viagem
2. Gerenciar Pagamentos
3. Sair
```

### 2. Gerenciamento de Turistas e Pacotes de Viagem

Ao escolher a opção **1** no menu principal, o sistema redireciona o usuário para o **Menu de Turistas e Pacotes**. Este menu permite o cadastro de novos turistas, a associação de pacotes de viagem, além de operações de consulta, atualização e remoção.

**Exemplo de Menu de Turistas e Pacotes**:

```
=== Gerenciar Turistas e Pacotes de Viagem ===
1. Cadastrar Turista e Pacote de Viagem
2. Listar Turistas e Pacotes
3. Atualizar Turista ou Pacote
4. Remover Turista
5. Voltar ao Menu Principal
```

#### Fluxo de Cadastro de Turista e Pacote

1. Escolha a opção **1** para cadastrar um novo turista.
2. Insira os dados do turista (nome, CPF, email, telefone e endereço).
3. Em seguida, será solicitado o cadastro do pacote de viagem, com os seguintes dados:
   - Tipo do pacote (Nacional ou Internacional)
   - Destino
   - Duração (em dias)
   - Nível do pacote (Completo, Luxo ou Standard)

### 3. Gerenciamento de Pagamentos

Ao escolher a opção **2** no menu principal, o sistema redireciona o usuário para o **Menu de Pagamentos**. Este menu permite o registro e consulta de pagamentos, separando entre pagos e pendentes.

**Exemplo de Menu de Pagamentos**:

```
=== Gerenciar Pagamentos ===
1. Registrar Novo Pagamento
2. Listar Pagamentos Pendentes
3. Listar Pagamentos Concluídos
4. Voltar ao Menu Principal
```

---

## Instalação e Execução

### Passo 1: Clonar o Repositório

Clone o repositório do projeto para a sua máquina local:

```bash
git clone https://github.com/seuusuario/seuprojeto.git
```

### Passo 2: Navegar até o Diretório do Projeto

Depois de clonar o repositório, navegue até a pasta do projeto:

```bash
cd seuprojeto
```

### Passo 3: Compilar o Projeto

Certifique-se de que o **JDK** está instalado corretamente. Para compilar todos os arquivos `.java`:

```bash
javac -d bin src/**/*.java
```

### Passo 4: Executar o Sistema

Para rodar o sistema, utilize o seguinte comando:

```bash
java -cp bin AgenciaViagemMenu
```

---

## Estrutura de Dados

O sistema armazena as informações principais sobre **Turistas**, **Pacotes de Viagem**, e **Pagamentos**. Abaixo estão as principais entidades e seus atributos:

- **Turista**:
  - ID
  - Nome
  - CPF
  - Email
  - Telefone
  - Endereço

- **Pacote de Viagem**:
  - ID
  - Tipo (Nacional ou Internacional)
  - Destino
  - Duração (em dias)
  - Nível (Completo, Luxo, Standard)
  - Relacionado a um Turista

- **Pagamento**:
  - ID
  - Valor
  - Data de Pagamento
  - Status (Pago ou Pendente)
  - Forma de Pagamento (Cartão de Crédito, Boleto, Pix)
  - Relacionado a um Turista

---

## Padrões Utilizados

Durante o desenvolvimento deste sistema, aplicamos padrões de design **GRASP** e **GOF**:

- **GRASP - Controlador**: Utilizamos classes controladoras como `TuristaController` e `PagamentoController` para centralizar a lógica e controlar as operações principais do sistema.
- **GRASP - Alta Coesão e Baixo Acoplamento**: As classes são altamente coesas, com cada uma desempenhando uma função específica, e com baixo acoplamento para facilitar manutenção e evolução do código.
- **GOF - Factory Method**: O padrão **Factory Method** foi utilizado para criar instâncias de `PacoteViagem` e `Pagamento`, permitindo a criação de objetos de forma centralizada e flexível.

---

## Considerações Finais

O **Sistema de Gerenciamento de Agência de Viagens** foi desenvolvido para ser uma ferramenta útil e eficiente para o gerenciamento de turistas, pacotes de viagem e pagamentos. Com um menu simples e intuitivo, ele oferece uma solução prática para o dia a dia de uma agência de viagens.

Sinta-se à vontade para modificar e expandir o sistema conforme as necessidades da agência.
