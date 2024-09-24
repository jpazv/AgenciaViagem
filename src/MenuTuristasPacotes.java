import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuTuristasPacotes {
    private TuristaController turistaController;
    private Scanner scanner;

    public MenuTuristasPacotes(TuristaController turistaController, Scanner scanner) {
        this.turistaController = turistaController;
        this.scanner = scanner;
    }

    public void exibirMenu() {
        boolean voltar = false;
        while (!voltar) {
            try {
                System.out.println("\n=== Gerenciar Turistas e Pacotes de Viagem ===");
                listarTuristas();  // Lista todos os turistas
                System.out.println("1. Listar Turistas e Pacotes");
                System.out.println("2. Atualizar Turista ou Pacote ");
                System.out.println("3. Remover Turista");
                System.out.println("4. Voltar ao Menu Principal");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a quebra de linha

                switch (opcao) {
                    case 1:
                        listarTuristas();
                        break;
                    case 2:
                        atualizarTuristaOuPacote();
                        break;
                    case 3:
                        removerTurista();
                        break;
                    case 4:
                        voltar = true;
                        break; // Volta ao menu anterior
                    default:
                        throw new IllegalArgumentException("Opção inválida, tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();  // Consumir o input inválido e evitar loop infinito
            }
        }
    }

    private void listarTuristas() {
        System.out.println("\n=== Lista de Turistas e Pacotes ===");
        for (Turista turista : turistaController.getTuristas()) {
            System.out.println("Turista: " + turista.getNome() + ", CPF: " + turista.getCpf());
            for (PacoteViagem pacote : turista.getPacotes()) {
                System.out.println("  - " + pacote.descreverPacote());
            }
        }
    }

    private void atualizarTuristaOuPacote() {
        System.out.println("\nDigite o nome do turista que deseja atualizar:");
        String nomeTurista = scanner.nextLine();

        Turista turista = turistaController.buscarTuristaPorNome(nomeTurista);

        if (turista != null) {
            System.out.println("O que você deseja atualizar?");
            System.out.println("1. Atualizar informações do Turista");
            System.out.println("2. Atualizar Pacote de Viagem do Turista");
            int escolha = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha

            switch (escolha) {
                case 1:
                    atualizarTurista(turista);
                    break;
                case 2:
                    atualizarPacoteDoTurista(turista);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } else {
            System.out.println("Turista não encontrado.");
        }
    }

    private void atualizarTurista(Turista turista) {
        System.out.println("Atualizando turista: " + turista.getNome());

        System.out.print("Digite o novo nome do turista: ");
        turista.setNome(scanner.nextLine());

        System.out.print("Digite o novo CPF do turista: ");
        turista.setCpf(scanner.nextLine());

        System.out.print("Digite o novo email do turista: ");
        turista.setEmail(scanner.nextLine());

        System.out.print("Digite o novo telefone do turista: ");
        turista.setTelefone(scanner.nextInt());
        scanner.nextLine();  // Consumir a quebra de linha

        System.out.print("Digite o novo endereço do turista: ");
        turista.setEndereco(scanner.nextLine());


        System.out.println("Turista atualizado com sucesso!");
    }

    private void atualizarPacoteDoTurista(Turista turista) {
        if (turista.getPacotes().isEmpty()) {
            System.out.println("O turista não possui pacotes cadastrados.");
            return;
        }

        PacoteViagem pacote = turista.getPacotes().get(0);  // Supondo que há apenas um pacote por enquanto
        System.out.println("Atualizando pacote: " + pacote.descreverPacote());

        System.out.print("Digite o novo destino do pacote: ");
        pacote.setDestino(scanner.nextLine());

        System.out.print("Digite a nova duração do pacote (em dias): ");
        pacote.setDuracao(scanner.nextInt());
        scanner.nextLine();  // Consumir a quebra de linha

        System.out.print("Digite o novo nível do pacote (Completo/Luxo/Standard): ");
        pacote.setNivel(scanner.nextLine());

        System.out.println("Pacote de viagem atualizado com sucesso!");
    }

    private void removerTurista() {
        System.out.println("\nDigite o nome do turista que deseja remover:");
        String nomeTurista = scanner.nextLine();

        Turista turista = turistaController.buscarTuristaPorNome(nomeTurista);

        if (turista != null) {
            turistaController.removerTurista(turista.getId());
            System.out.println("Turista removido com sucesso!");
        } else {
            System.out.println("Turista não encontrado.");
        }
    }
}
