import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class MenuTurista {
    private Turista turista;
    private TuristaController turistaController;
    private PagamentoController pagamentoController;
    private Scanner scanner;

    public MenuTurista(Turista turista, TuristaController turistaController, Scanner scanner) {
        this.turista = turista;
        this.turistaController = turistaController;
        this.pagamentoController = pagamentoController;
        this.scanner = scanner;
    }

    public void exibirMenuTurista() {
        boolean sair = false;
        while (!sair) {
            try {
                System.out.println("\n=== Menu do Cliente ===");
                System.out.println("1. Visualizar Pacotes Existentes e Comprar");
                System.out.println("2. Criar Pacote Personalizado e Comprar");
                System.out.println("3. Listar Minhas Viagens");
                System.out.println("4. Listar Meus Pagamentos");
                System.out.println("5. Voltar ao Menu Principal");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a quebra de linha

                switch (opcao) {
                    case 1:
                        listarPacotesDisponiveis();
                        break;
                    case 2:
                        criarPacotePersonalizado();
                        break;
                    case 3:
                        listarMinhasViagens();
                        break;
                    case 4:
                        listarMeusPagamentos();
                        break;
                    case 5:
                        sair = true;
                        break;
                    default:
                        throw new IllegalArgumentException("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private void listarPacotesDisponiveis() {
        System.out.println("\n=== Pacotes Disponíveis ===");
        List<PacoteViagem> pacotesDisponiveis = turistaController.getPacotesDisponiveis();

        if (pacotesDisponiveis.isEmpty()) {
            System.out.println("Nenhum pacote disponível.");
            return;
        }

        for (int i = 0; i < pacotesDisponiveis.size(); i++) {
            System.out.println((i + 1) + ". " + pacotesDisponiveis.get(i).descreverPacote());
        }

        System.out.print("Escolha um pacote para adicionar ou digite 0 para cancelar: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha > 0 && escolha <= pacotesDisponiveis.size()) {
            PacoteViagem pacoteEscolhido = pacotesDisponiveis.get(escolha - 1);
            turista.adicionarPacote(pacoteEscolhido);

            System.out.println("Você escolheu o pacote para " + pacoteEscolhido.getDestino());
            System.out.print("Deseja comprar este pacote agora? (1 - Sim, 2 - Não): ");
            int comprarAgora = scanner.nextInt();
            scanner.nextLine();

            if (comprarAgora == 1) {
                realizarCompra(pacoteEscolhido);
            } else {
                System.out.println("Pacote adicionado ao perfil, mas compra não realizada.");
            }
        } else {
            System.out.println("Operação cancelada.");
        }
    }


    private void criarPacotePersonalizado() {
        System.out.println("\n=== Criar Pacote de Viagem ===");

        System.out.print("Digite o destino: ");
        String destino = scanner.nextLine();

        System.out.print("Digite a duração (em dias): ");
        int duracao = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nível do pacote (Completo/Luxo/Standard): ");
        String nivel = scanner.nextLine();


        PacoteViagem pacote = PacoteViagemFactory.criarPacote("Personalizado", destino, duracao, nivel);
        double precoPacote = calcularPrecoPacote(pacote);

        System.out.println("Pacote personalizado criado para " + destino + " com o preço estimado de R$" + precoPacote);

        System.out.print("Deseja comprar este pacote agora? (1 - Sim, 2 - Não): ");
        int comprarAgora = scanner.nextInt();
        scanner.nextLine();

        if (comprarAgora == 1) {
            realizarCompra(pacote);
        } else {
            System.out.println("Pacote não comprado.");
        }
    }


    private double calcularPrecoPacote(PacoteViagem pacote) {

        double precoBase = 500.00;
        double multiplicadorNivel = 1.0;

        switch (pacote.getNivel()) {
            case "Completo":
                multiplicadorNivel = 2.0;
                break;
            case "Luxo":
                multiplicadorNivel = 3.0;
                break;
            case "Standard":
                multiplicadorNivel = 1.5;
                break;
        }

        return precoBase * pacote.getDuracao() * multiplicadorNivel;
    }

    private void realizarCompra(PacoteViagem pacote) {
        System.out.println("\n=== Realizar Compra ===");

        System.out.print("Digite o valor do pagamento (ou o preço do pacote): ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("O pagamento será realizado agora ou posteriormente?");
        System.out.println("1. Agora");
        System.out.println("2. Posteriormente");
        System.out.print("Escolha uma opção: ");
        int opcaoPagamento = scanner.nextInt();
        scanner.nextLine();

        String status = (opcaoPagamento == 1) ? "Pago" : "Pendente";

        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1. Cartão de Crédito");
        System.out.println("2. Boleto");
        System.out.println("3. Pix");
        System.out.print("Escolha uma opção: ");
        int opcaoForma = scanner.nextInt();
        scanner.nextLine();

        String formaPagamento = escolherFormaPagamento(opcaoForma);

        Pagamento pagamento = new Pagamento(valor, LocalDate.now(), status, formaPagamento);
        turista.adicionarPagamento(pagamento);

        System.out.println("Compra realizada com sucesso!");
    }

    private void listarMinhasViagens() {
        System.out.println("\n=== Minhas Viagens ===");

        List<PacoteViagem> pacotesDoTurista = turista.getPacotes();
        if (pacotesDoTurista.isEmpty()) {
            System.out.println("Você não tem nenhuma viagem cadastrada.");
        } else {
            for (PacoteViagem pacote : pacotesDoTurista) {
                System.out.println(pacote.descreverPacote());
            }
        }
    }

    private void listarMeusPagamentos() {
        System.out.println("\n=== Meus Pagamentos ===");

        List<Pagamento> pagamentos = turista.getPagamentos();

        System.out.println("Pagamentos Pendentes:");
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.getStatus().equalsIgnoreCase("Pendente")) {
                System.out.println(pagamento.descreverPagamento());
            }
        }

        System.out.println("\nPagamentos Concluídos:");
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.getStatus().equalsIgnoreCase("Pago")) {
                System.out.println(pagamento.descreverPagamento());
            }
        }
    }

    private String escolherFormaPagamento(int opcao) {
        switch (opcao) {
            case 1:
                return "Cartão de Crédito";
            case 2:
                return "Boleto";
            case 3:
                return "Pix";
            default:
                return "Forma de pagamento desconhecida";
        }
    }
}
