import java.util.ArrayList;
import java.util.List;

public class TuristaController {
    private List<Turista> turistas;
    private List<PacoteViagem> pacotesDisponiveis;

    public TuristaController() {
        this.turistas = new ArrayList<>();
        this.pacotesDisponiveis = new ArrayList<>();
        inicializarPacotes();
    }

    // Inicializa pacotes predefinidos
    private void inicializarPacotes() {
        PacoteViagem pacote1 = PacoteViagemFactory.criarPacote("Nacional", "Foz do Iguaçu", 7, "Completo");
        PacoteViagem pacote2 = PacoteViagemFactory.criarPacote("Internacional", "Paris", 10, "Luxo");
        PacoteViagem pacote3 = PacoteViagemFactory.criarPacote("Nacional", "Fernando de Noronha", 5, "Standard");
        PacoteViagem pacote4 = PacoteViagemFactory.criarPacote("Internacional", "Nova York", 7, "Completo");

        pacotesDisponiveis.add(pacote1);
        pacotesDisponiveis.add(pacote2);
        pacotesDisponiveis.add(pacote3);
        pacotesDisponiveis.add(pacote4);
    }

    // Retorna a lista de pacotes disponíveis
    public List<PacoteViagem> getPacotesDisponiveis() {
        return pacotesDisponiveis;
    }

    // Adicionar turista
    public void adicionarTurista(Turista turista) {
        turistas.add(turista);
        System.out.println("Turista adicionado com sucesso!");
    }

    // Buscar turista por nome
    public Turista buscarTuristaPorNome(String nome) {
        for (Turista turista : turistas) {
            if (turista.getNome().equalsIgnoreCase(nome)) {
                return turista;
            }
        }
        System.out.println("Turista não encontrado.");
        return null;
    }

    // Buscar turista por login (novo método)
    public Turista buscarTuristaPorLogin(String login) {
        for (Turista turista : turistas) {
            if (turista.getLogin().equalsIgnoreCase(login)) {
                return turista;
            }
        }
        System.out.println("Turista com login '" + login + "' não encontrado.");
        return null;
    }

    // Atualizar senha do turista
    public void atualizarSenhaTurista(String login, String novaSenha) {
        Turista turista = buscarTuristaPorLogin(login);
        if (turista != null) {
            turista.setSenha(novaSenha);
            System.out.println("Senha atualizada com sucesso para o turista " + turista.getNome());
        } else {
            System.out.println("Turista não encontrado para atualizar a senha.");
        }
    }

    // Remover pagamento de um turista
    public void removerPagamentoDoTurista(int idTurista, int idPagamento) {
        Turista turista = buscarTuristaPorId(idTurista);
        if (turista != null) {
            Pagamento pagamentoARemover = null;
            for (Pagamento pagamento : turista.getPagamentos()) {
                if (pagamento.getId() == idPagamento) {
                    pagamentoARemover = pagamento;
                    break;
                }
            }
            if (pagamentoARemover != null) {
                turista.removerPagamento(pagamentoARemover);
                System.out.println("Pagamento removido com sucesso!");
            } else {
                System.out.println("Pagamento com ID " + idPagamento + " não encontrado.");
            }
        } else {
            System.out.println("Turista com ID " + idTurista + " não encontrado.");
        }
    }

    // Buscar turista por ID
    public Turista buscarTuristaPorId(int id) {
        for (Turista turista : turistas) {
            if (turista.getId() == id) {
                return turista;
            }
        }
        return null;
    }

    // Remover turista pelo ID
    public void removerTurista(int id) {
        Turista turistaARemover = buscarTuristaPorId(id);
        if (turistaARemover != null) {
            turistas.remove(turistaARemover);
            System.out.println("Turista removido com sucesso!");
        } else {
            System.out.println("Turista com ID " + id + " não encontrado.");
        }
    }

    // Retorna a lista de turistas
    public List<Turista> getTuristas() {
        return turistas;
    }
}
