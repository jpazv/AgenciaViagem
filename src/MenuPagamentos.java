import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class MenuPagamentos {
    private TuristaController turistaController;
    private PagamentoController pagamentoController;
    private Scanner scanner;
    private LocalDate dataPagamento;

    public MenuPagamentos(TuristaController turistaController, PagamentoController pagamentoController, Scanner scanner) {
        this.turistaController = turistaController;
        this.pagamentoController = pagamentoController;
        this.scanner = scanner;
    }

    public void exibirMenu() {
        boolean voltar = false;
        while (!voltar) {
            try {
                System.out.println("\n=== Gerenciar Pagamentos ===");
                listarTuristasESeusPagamentos();  // Lista os turistas e pagamentos
                System.out.println("1. Cadastrar Compra");
                System.out.println("2. Listar Pagamentos Pendentes");
                System.out.println("3. Listar Pagamentos Concluídos");
                System.out.println("4. Remover Pagamento");
                System.out.println("5. Voltar ao Menu Principal");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a quebra de linha

                switch (opcao) {
                    case 1:
                        cadastrarPagamento();
                        break;
                    case 2:
                        listarPagamentosPendentes();
                        break;
                    case 3:
                        listarPagamentosConcluidos();
                        break;
                    case 4:
                        removerPagamento();
                        break;
                    case 5:
                        voltar = true;  // Volta ao menu anterior
                        break;
                    default:
                        throw new IllegalArgumentException("Opção inválida, tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();  // Consumir o input inválido e evitar loop infinito
            }
        }
    }

    private void listarTuristasESeusPagamentos() {
        System.out.println("\n=== Lista de Turistas e seus Pagamentos ===");
        for (Turista turista : turistaController.getTuristas()) {
            System.out.println("Turista: " + turista.getNome());
            for (Pagamento pagamento : turista.getPagamentos()) {
                System.out.println("  - " + pagamento.descreverPagamento());
            }
        }
    }

    private void cadastrarPagamento() {
        System.out.print("Digite o nome do turista: ");
        String nomeTurista = scanner.nextLine();
        Turista turista = turistaController.buscarTuristaPorNome(nomeTurista);
        if (turista == null) {
            System.out.println("Turista não encontrado.");
            return;
        }

        System.out.print("Digite o valor do pagamento: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();  // Consumir a quebra de linha

        // Data do pagamento gerada automaticamente
        LocalDate dataPagamento = LocalDate.now();

        System.out.println("O pagamento será realizado agora ou posteriormente?");
        System.out.println("1. Agora");
        System.out.println("2. Posteriormente");
        System.out.print("Escolha uma opção: ");
        int opcaoPagamento = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha

        String status;
        if (opcaoPagamento == 1) {
            status = "Pago";
        } else if (opcaoPagamento == 2) {
            status = "Pendente";
        } else {
            System.out.println("Opção inválida, pagamento será considerado como pendente.");
            status = "Pendente";
        }

        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1. Cartão de Crédito");
        System.out.println("2. Boleto");
        System.out.println("3. Pix");
        System.out.print("Escolha uma opção: ");
        int opcaoForma = scanner.nextInt();
        scanner.nextLine();

        String formaPagamento = escolherFormaPagamento(opcaoForma);


        Pagamento pagamento = new Pagamento(valor, dataPagamento, status, formaPagamento);
        turista.adicionarPagamento(pagamento);
        System.out.println("Pagamento cadastrado com sucesso!\n");
    }


    private void listarPagamentosPendentes() {
        System.out.println("\n=== Lista de Pagamentos Pendentes ===");

        boolean encontrouPagamentos = false;

        for (Turista turista : turistaController.getTuristas()) {
            for (Pagamento pagamento : turista.getPagamentos()) {
                if (pagamento.getStatus().equalsIgnoreCase("Pendente")) {
                    System.out.println("Turista: " + turista.getNome() + " | CPF: " + turista.getCpf());
                    System.out.println("Valor: R$ " + pagamento.getValor() + " | Data do Pagamento: " + pagamento.getDataPagamento());
                    System.out.println("Forma de Pagamento: " + pagamento.getFormaPagamento() + " | Status: " + pagamento.getStatus());
                    System.out.println("--------------------------------------------------");
                    encontrouPagamentos = true;
                }
            }
        }

        if (!encontrouPagamentos) {
            System.out.println("Nenhum pagamento pendente encontrado.");
        }
    }

    private void listarPagamentosConcluidos() {
        System.out.println("\n=== Lista de Pagamentos Concluídos ===");

        boolean encontrouPagamentos = false; // Variável para verificar se há pagamentos concluídos

        for (Turista turista : turistaController.getTuristas()) {
            for (Pagamento pagamento : turista.getPagamentos()) {
                if (pagamento.getStatus().equalsIgnoreCase("Pago")) {
                    System.out.println("Turista: " + turista.getNome() + " | CPF: " + turista.getCpf());
                    System.out.println("Valor: R$ " + pagamento.getValor() + " | Data do Pagamento: " + pagamento.getDataPagamento());
                    System.out.println("Forma de Pagamento: " + pagamento.getFormaPagamento() + " | Status: " + pagamento.getStatus());
                    System.out.println("--------------------------------------------------");
                    encontrouPagamentos = true;
                }
            }
        }

        if (!encontrouPagamentos) {
            System.out.println("Nenhum pagamento concluído encontrado.");
        }
    }


    private void removerPagamento() {
        System.out.print("Digite o nome do turista: ");
        String nomeTurista = scanner.nextLine();
        Turista turista = turistaController.buscarTuristaPorNome(nomeTurista);
        if (turista == null) {
            System.out.println("Turista não encontrado.");
            return;
        }

        System.out.print("Digite o ID do pagamento que deseja remover: ");
        int idPagamento = scanner.nextInt();
        scanner.nextLine();

        turistaController.removerPagamentoDoTurista(turista.getId(), idPagamento);
    }

    private String escolherFormaPagamento(int opcaoForma) {
        switch (opcaoForma) {
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
