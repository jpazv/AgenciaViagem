
# Sistema de Gerenciamento de Agência de Viagens

Este sistema foi desenvolvido em **Java** para gerenciar turistas, pacotes de viagem e pagamentos em uma agência de viagens. Ele permite que dois tipos de usuários, **Funcionários** e **Turistas**, interajam com o sistema para realizar operações de gerenciamento e compra de pacotes de viagem.

## Funcionalidades

### Para Funcionários:
- **Gerenciamento de Turistas**: Cadastrar, atualizar, listar e remover turistas.
- **Gerenciamento de Pacotes de Viagem**: Associar pacotes a turistas, listar, atualizar e remover pacotes.
- **Gerenciamento de Pagamentos**: Listar pagamentos pendentes e concluídos, associar pagamentos a turistas, e registrar novos pagamentos.

### Para Turistas:
- **Login e Cadastro**: Criação de conta com login e senha, opção de recuperação de senha.
- **Compra de Pacotes de Viagem**: Visualizar pacotes de viagem disponíveis, escolher e comprar pacotes.
- **Criação de Pacotes Personalizados**: Criar pacotes personalizados com destino, duração e nível de serviço, com preço calculado dinamicamente.
- **Listar Minhas Viagens**: Ver todos os pacotes que já foram adquiridos ou adicionados ao perfil do turista.
- **Listar Meus Pagamentos**: Verificar pagamentos pendentes e concluídos, exibindo todos os detalhes de cada pagamento.

---

## Fluxo de Uso

O sistema é baseado em um menu interativo que permite ao usuário navegar pelas opções de forma simples e intuitiva.

### 1. Menu Inicial

Ao iniciar o sistema, o usuário será apresentado ao **Menu Inicial**, onde poderá escolher se deseja entrar como **Funcionário** ou **Turista**. Dependendo da escolha, o usuário terá a opção de **cadastrar uma nova conta** ou **entrar com uma conta existente**.

```
=== Menu Inicial ===
1. Login como Funcionário
2. Criar Conta de Turista
3. Login como Turista
4. Sair
```

### 2. Menu de Funcionários

Após o login, o funcionário terá acesso ao **Menu de Funcionários** para gerenciar turistas, pacotes e pagamentos. As opções incluem:

```
=== Menu Funcionário ===
1. Gerenciar Turistas
2. Gerenciar Pacotes de Viagem
3. Gerenciar Pagamentos
4. Sair
```

#### Gerenciamento de Turistas e Pacotes

O funcionário pode adicionar, listar, atualizar e remover turistas, além de associar pacotes de viagem a turistas.

```
=== Gerenciar Turistas ===
1. Cadastrar Turista
2. Listar Turistas
3. Atualizar Turista
4. Remover Turista
5. Voltar ao Menu Funcionário
```

### 3. Menu de Turistas

Após o login, o turista terá acesso ao **Menu de Turistas** onde poderá visualizar pacotes, criar pacotes personalizados, e gerenciar suas viagens e pagamentos.

```
=== Menu do Cliente ===
1. Visualizar Pacotes Existentes e Comprar
2. Criar Pacote Personalizado e Comprar
3. Listar Minhas Viagens
4. Listar Meus Pagamentos
5. Voltar ao Menu Principal
```

#### Compra de Pacotes

O turista pode visualizar os pacotes de viagem disponíveis e optar por comprá-los. Há também a opção de criar um **pacote personalizado**, onde ele poderá especificar destino, duração e nível de serviço. O sistema calculará o preço com base nessas informações.

#### Gerenciamento de Pagamentos

Os turistas podem listar seus pagamentos pendentes e concluídos diretamente no menu. O sistema exibe todos os detalhes de cada pagamento, como valor, data e status (pago ou pendente).

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

O sistema armazena as informações principais sobre **Funcionários**, **Turistas**, **Pacotes de Viagem** e **Pagamentos**.

### Entidades

- **Turista**:
  - ID
  - Nome
  - CPF
  - Email
  - Telefone
  - Endereço
  - Login
  - Senha
  - Lista de Pacotes
  - Lista de Pagamentos

- **Funcionário**:
  - Nome
  - Login
  - Senha

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
