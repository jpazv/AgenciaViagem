import java.util.Scanner;
import java.time.LocalDate;

public class AgenciaViagemMenu {
    private static TuristaController turistaController = new TuristaController();
    private static FuncionarioController funcionarioController = new FuncionarioController();
    static PagamentoController pagamentoController = new PagamentoController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarTuristasEPacotes();
        MenuPrincipal menuPrincipal = new MenuPrincipal(turistaController, funcionarioController, pagamentoController, scanner);
        menuPrincipal.exibirMenuPrincipal();

        boolean executando = true;
        while (executando) {
            try {
                // Exibir Menu Principal
                System.out.println("\n=== Menu Principal ===");
                System.out.println("1. Gerenciar Turistas e Pacotes de Viagem");
                System.out.println("2. Gerenciar Pagamentos");
                System.out.println("3. Sair");
                System.out.print("Escolha uma opção: ");

                // Tentar ler a opção do usuário
                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a quebra de linha

                switch (opcao) {
                    case 1:
                        new MenuTuristasPacotes(turistaController, scanner).exibirMenu();
                        break;
                    case 2:
                        new MenuPagamentos(turistaController, pagamentoController, scanner).exibirMenu();
                        break;
                    case 3:
                        System.out.println("Saindo...");
                        executando = false;
                        break;
                    default:
                        throw new IllegalArgumentException("Opção inválida. Escolha entre 1, 2 ou 3.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine();  // Consumir a entrada inválida e evitar loop infinito
            }
        }
    }

    // Inicializa os turistas e pacotes (conforme exemplo anterior)
    private static void inicializarTuristasEPacotes() {
        // Criar Turista 1 com login e senha e associar um pacote de viagem
        Turista turista1 = TuristaFactory.criarTurista("João Silva", "12345678900", "joao@email.com", 987654321, "Rua das Flores, 123", "joaosilva", "senha123");
        PacoteViagem pacote1 = PacoteViagemFactory.criarPacote("Nacional", "Foz do Iguaçu", 7, "Completo");
        turista1.adicionarPacote(pacote1);

        // Adicionar pagamentos para o Turista 1
        Pagamento pagamento1 = new Pagamento(2000.00, LocalDate.now(), "Pendente", "Pix");
        Pagamento pagamento2 = new Pagamento(1500.00, LocalDate.now().minusDays(5), "Pago", "Cartão de Crédito");
        turista1.adicionarPagamento(pagamento1);
        turista1.adicionarPagamento(pagamento2);

        turistaController.adicionarTurista(turista1);

        // Criar Turista 2 com login e senha e associar um pacote de viagem
        Turista turista2 = TuristaFactory.criarTurista("Maria Souza", "98765432100", "maria@email.com", 123456789, "Rua das Orquídeas, 456", "mariasouza", "senha456");
        PacoteViagem pacote2 = PacoteViagemFactory.criarPacote("Internacional", "Paris", 10, "Luxo");
        turista2.adicionarPacote(pacote2);

        // Adicionar pagamentos para o Turista 2
        Pagamento pagamento3 = new Pagamento(5000.00, LocalDate.now(), "Pendente", "Boleto");
        Pagamento pagamento4 = new Pagamento(4000.00, LocalDate.now().minusDays(10), "Pago", "Cartão de Crédito");
        turista2.adicionarPagamento(pagamento3);
        turista2.adicionarPagamento(pagamento4);

        turistaController.adicionarTurista(turista2);

        // Criar Turista 3 com login e senha e associar um pacote de viagem
        Turista turista3 = TuristaFactory.criarTurista("Carlos Pereira", "45678912300", "carlos@email.com", 234567890, "Rua das Palmeiras, 789", "carlospereira", "senha789");
        PacoteViagem pacote3 = PacoteViagemFactory.criarPacote("Nacional", "Fernando de Noronha", 5, "Standard");
        turista3.adicionarPacote(pacote3);

        // Adicionar pagamentos para o Turista 3
        Pagamento pagamento5 = new Pagamento(3000.00, LocalDate.now(), "Pendente", "Boleto");
        turista3.adicionarPagamento(pagamento5);

        turistaController.adicionarTurista(turista3);

        // Criar Turista 4 com login e senha e associar um pacote de viagem
        Turista turista4 = TuristaFactory.criarTurista("Ana Costa", "65432198700", "ana@email.com", 876543210, "Rua das Margaridas, 101", "anacosta", "senha321");
        PacoteViagem pacote4 = PacoteViagemFactory.criarPacote("Internacional", "Nova York", 7, "Completo");
        turista4.adicionarPacote(pacote4);

        // Adicionar pagamentos para o Turista 4
        Pagamento pagamento6 = new Pagamento(6000.00, LocalDate.now().minusDays(3), "Pago", "Pix");
        turista4.adicionarPagamento(pagamento6);

        turistaController.adicionarTurista(turista4);
    }


}
