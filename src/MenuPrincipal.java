import java.util.Scanner;

public class MenuPrincipal {
    private TuristaController turistaController;
    private FuncionarioController funcionarioController;
    private Scanner scanner;

    public MenuPrincipal(TuristaController turistaController, FuncionarioController funcionarioController, PagamentoController pagamentoController, Scanner scanner) {
        this.turistaController = turistaController;
        this.funcionarioController = funcionarioController;
        this.scanner = scanner;
    }

    public void exibirMenuPrincipal() {
        boolean sair = false;
        while (!sair) {
            try {
                System.out.println("\n=== Menu Principal ===");
                System.out.println("1. Entrar como Funcionário");
                System.out.println("2. Entrar como Turista");
                System.out.println("3. Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a quebra de linha

                switch (opcao) {
                    case 1:
                        menuFuncionario();
                        break;
                    case 2:
                        menuTurista();
                        break;
                    case 3:
                        sair = true;
                        break;
                    default:
                        throw new IllegalArgumentException("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();  // Consumir a entrada inválida
            }
        }
    }

    // Menu para escolher entre cadastrar ou entrar como funcionário
    private void menuFuncionario() {
        boolean voltar = false;
        while (!voltar) {
            try {
                System.out.println("\n=== Menu Funcionário ===");
                System.out.println("1. Cadastrar novo Funcionário");
                System.out.println("2. Entrar em uma conta de Funcionário");
                System.out.println("3. Voltar ao Menu Principal");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a quebra de linha

                switch (opcao) {
                    case 1:
                        cadastrarFuncionario();
                        break;
                    case 2:
                        loginFuncionario();
                        break;
                    case 3:
                        voltar = true;
                        break;
                    default:
                        throw new IllegalArgumentException("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();  // Consumir a entrada inválida
            }
        }
    }

    // Menu para escolher entre cadastrar ou entrar como turista
    private void menuTurista() {
        boolean voltar = false;
        while (!voltar) {
            try {
                System.out.println("\n=== Menu Turista ===");
                System.out.println("1. Cadastrar novo Turista");
                System.out.println("2. Entrar em uma conta de Turista");
                System.out.println("3. Voltar ao Menu Principal");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a quebra de linha

                switch (opcao) {
                    case 1:
                        cadastrarTurista();
                        break;
                    case 2:
                        loginTurista();
                        break;
                    case 3:
                        voltar = true;
                        break;
                    default:
                        throw new IllegalArgumentException("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();  // Consumir a entrada inválida
            }
        }
    }

    // Cadastro de Funcionário
    private void cadastrarFuncionario() {
        System.out.println("\n=== Cadastrar Funcionário ===");
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Crie seu login: ");
        String login = scanner.nextLine();
        System.out.print("Crie sua senha: ");
        String senha = scanner.nextLine();

        Funcionario funcionario = new Funcionario(nome, login, senha);
        funcionarioController.adicionarFuncionario(funcionario);

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    // Login de Funcionário
    private void loginFuncionario() {
        System.out.println("\n=== Login de Funcionário ===");
        System.out.print("Digite seu login: ");
        String login = scanner.nextLine();

        Funcionario funcionario = funcionarioController.buscarFuncionarioPorLogin(login);
        if (funcionario == null) {
            System.out.println("Login não encontrado.");
            return;
        }

        int tentativas = 3;
        while (tentativas > 0) {
            System.out.print("Digite sua senha (ou digite 'esqueci' para recuperar a senha): ");
            String senha = scanner.nextLine();

            if (senha.equals("esqueci")) {
                System.out.println("Sua senha é: " + funcionario.getSenha());
                continue;
            }

            if (funcionario.getSenha().equals(senha)) {
                System.out.println("Login realizado com sucesso!");
                new MenuFuncionarios(turistaController, AgenciaViagemMenu.pagamentoController, scanner).exibirMenu();  // Agora você tem o MenuFuncionarios
                return;

            } else {
                tentativas--;
                System.out.println("Senha incorreta. Tentativas restantes: " + tentativas);
            }
        }

        System.out.println("Você excedeu o número de tentativas. Tente novamente mais tarde.");
    }

    // Cadastro de Turista
    private void cadastrarTurista() {
        System.out.println("\n=== Cadastrar Turista ===");
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        System.out.print("Digite o telefone: ");
        int telefone = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha
        System.out.print("Digite o endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Crie seu login: ");
        String login = scanner.nextLine();
        System.out.print("Crie sua senha: ");
        String senha = scanner.nextLine();

        Turista turista = new Turista(nome, cpf, email, telefone, endereco, login, senha);
        turistaController.adicionarTurista(turista);

        System.out.println("Conta de turista criada com sucesso!");
    }

    // Login de Turista
    private void loginTurista() {
        System.out.println("\n=== Login de Turista ===");
        System.out.print("Digite seu login: ");
        String login = scanner.nextLine();

        Turista turista = turistaController.buscarTuristaPorLogin(login);
        if (turista == null) {
            System.out.println("Login não encontrado.");
            return;
        }

        int tentativas = 3;
        while (tentativas > 0) {
            System.out.print("Digite sua senha (ou digite 'esqueci' para recuperar a senha): ");
            String senha = scanner.nextLine();

            if (senha.equals("esqueci")) {
                System.out.println("Sua senha é: " + turista.getSenha());
                continue;
            }

            if (turista.getSenha().equals(senha)) {
                System.out.println("Login realizado com sucesso!");
                new MenuTurista(turista, turistaController, scanner).exibirMenuTurista();
                return;
            } else {
                tentativas--;
                System.out.println("Senha incorreta. Tentativas restantes: " + tentativas);
            }
        }

        System.out.println("Você excedeu o número de tentativas. Tente novamente mais tarde.");
    }
}
