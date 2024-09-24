import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pagamento {
    private int id;
    private double valor;
    private LocalDate dataPagamento;
    private String status;
    private String formaPagamento;

    private static int idCounter = 1;


    public Pagamento(double valor ,LocalDate dataPagamento,  String status, String formaPagamento) {
        this.id = idCounter++;
        this.valor = valor;
        this.status = status;
        this.formaPagamento = formaPagamento;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    // Descrição do pagamento
    public String descreverPagamento() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Valor: " + valor + ", Data: " + dataPagamento.format(formatter) + ", Status: " + status + ", Forma de Pagamento: " + formaPagamento;
    }
}
