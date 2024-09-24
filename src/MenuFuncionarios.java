import java.util.Scanner;

public class MenuFuncionarios {
    private TuristaController turistaController;
    private PagamentoController pagamentoController;
    private Scanner scanner;

    public MenuFuncionarios(TuristaController turistaController, PagamentoController pagamentoController, Scanner scanner) {
        this.turistaController = turistaController;
        this.pagamentoController = pagamentoController;
        this.scanner = scanner;
    }

    public void exibirMenu() {
        boolean sair = false;
        while (!sair) {
            try {
                System.out.println("\n=== Menu Funcionário ===");
                System.out.println("1. Gerenciar Turistas");
                System.out.println("2. Gerenciar Pacotes de Viagem");
                System.out.println("3. Gerenciar Pagamentos");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a quebra de linha

                switch (opcao) {
                    case 1:
                        menuTuristas();
                        break;
                    case 2:
                        menuPacotes();
                        break;
                    case 3:
                        menuPagamentos();
                        break;
                    case 4:
                        sair = true;
                        break;
                    default:
                        throw new IllegalArgumentException("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();  // Consumir a entrada inválida e evitar loop infinito
            }
        }
    }

    private void menuTuristas() {
        MenuTuristasPacotes menuTuristas = new MenuTuristasPacotes(turistaController, scanner);
        menuTuristas.exibirMenu();
    }

    private void menuPacotes() {
        // Aqui, podemos adicionar um CRUD para pacotes de viagem se não estiver no menu de turistas.
        System.out.println("Gerenciamento de pacotes ainda não implementado diretamente.");
    }

    private void menuPagamentos() {
        MenuPagamentos menuPagamentos = new MenuPagamentos(turistaController, pagamentoController, scanner);
        menuPagamentos.exibirMenu();
    }
}
