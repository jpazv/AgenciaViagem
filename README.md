
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
   - Tipo do pacote (Nacional/Internacional)
   - Destino da viagem
   - Duração da viagem (em dias)
   - Nível do pacote (Completo, Luxo, Standard)

#### Fluxo de Listagem de Turistas

1. Escolha a opção **2** para listar todos os turistas cadastrados.
2. O sistema mostrará o nome, CPF, e os pacotes de viagem associados a cada turista.

#### Fluxo de Atualização de Dados

1. Escolha a opção **3** para atualizar os dados de um turista ou de um pacote de viagem.
2. Informe o nome do turista e escolha se deseja atualizar os dados pessoais ou os dados do pacote de viagem.

#### Fluxo de Remoção de Turista

1. Escolha a opção **4** para remover um turista.
2. Informe o nome do turista que deseja remover, e o sistema eliminará todos os pacotes e pagamentos associados a ele.

### 3. Gerenciamento de Pagamentos

Ao escolher a opção **2** no menu principal, o sistema redireciona o usuário para o **Menu de Gerenciamento de Pagamentos**. Este menu permite listar todos os turistas e seus pagamentos, cadastrar novos pagamentos, além de listar pagamentos pagos ou pendentes.

**Exemplo de Menu de Pagamentos**:

```
=== Gerenciar Pagamentos ===
1. Cadastrar Pagamento
2. Listar Pagamentos Pendentes
3. Listar Pagamentos Concluídos
4. Remover Pagamento
5. Voltar ao Menu Principal
```

#### Fluxo de Cadastro de Pagamento

1. Escolha a opção **1** para cadastrar um novo pagamento.
2. Informe o nome do turista ao qual o pagamento será associado.
3. Insira os detalhes do pagamento:
   - Valor do pagamento
   - Data do pagamento (formato: AAAA-MM-DD)
   - Status do pagamento (Pago ou Pendente)
   - Forma de pagamento (Cartão de Crédito, Boleto ou Pix)

#### Fluxo de Listagem de Pagamentos Pendentes ou Concluídos

1. Escolha a opção **2** para listar os pagamentos pendentes de um turista.
2. Escolha a opção **3** para listar os pagamentos já concluídos.
3. O sistema solicitará o nome do turista e exibirá a lista de pagamentos conforme o status selecionado.

#### Fluxo de Remoção de Pagamento

1. Escolha a opção **4** para remover um pagamento.
2. Informe o nome do turista e o ID do pagamento que deseja remover.

---

## Como Utilizar

### Pré-requisitos

1. **Java Development Kit (JDK)**: O projeto é escrito em Java, então você precisará do JDK instalado para compilar e executar o código.
2. **Banco de Dados**: Caso queira integrar o sistema a um banco de dados, utilize o DDL fornecido para criar as tabelas necessárias.

### Passos para Utilizar

1. **Clone o repositório**:
   ```bash
   git clone <url_do_repositorio>
   ```

2. **Compile o código**:
   No terminal, navegue até o diretório do projeto e compile o código:
   ```bash
   javac AgenciaViagemMenu.java
   ```

3. **Execute o sistema**:
   Após compilar, execute o sistema:
   ```bash
   java AgenciaViagemMenu
   ```

4. **Navegue pelos menus**:
   - Use o teclado para selecionar as opções desejadas e inserir as informações solicitadas.
   - Siga o fluxo de menus para gerenciar turistas, pacotes e pagamentos conforme necessário.

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
