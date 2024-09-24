import java.util.ArrayList;
import java.util.List;

public class PagamentoController {

    // Gerenciamento de pagamentos pendentes e pagos
    public List<Pagamento> listarPagamentosPendentes(Turista turista) {
        List<Pagamento> pendentes = new ArrayList<>();
        for (Pagamento pagamento : turista.getPagamentos()) {
            if (pagamento.getStatus().equalsIgnoreCase("Pendente")) {
                pendentes.add(pagamento);
            }
        }
        return pendentes;
    }

    public List<Pagamento> listarPagamentosConcluidos(Turista turista) {
        List<Pagamento> concluidos = new ArrayList<>();
        for (Pagamento pagamento : turista.getPagamentos()) {
            if (pagamento.getStatus().equalsIgnoreCase("Pago")) {
                concluidos.add(pagamento);
            }
        }
        return concluidos;
    }

    // Métodos de adicionar, atualizar e remover são manipulados dentro do contexto do TuristaController
}
