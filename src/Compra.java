import java.time.LocalDate;

public class Compra {
    private Turista turista;
    private PacoteViagem pacote;
    private LocalDate dataCompra;

    // Construtor
    public Compra(Turista turista, PacoteViagem pacote) {
        this.turista = turista;
        this.pacote = pacote;
        this.dataCompra = LocalDate.now(); // Data da compra é o dia atual
    }

    // Getters
    public Turista getTurista() {
        return turista;
    }

    public PacoteViagem getPacote() {
        return pacote;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    // Método para descrever a compra
    public String descreverCompra() {
        return "Turista: " + turista.getNome() + ", Pacote: " + pacote.descreverPacote() + ", Data: " + dataCompra;
    }
}
