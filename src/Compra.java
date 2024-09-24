import java.time.LocalDate;

public class Compra {
    private Turista turista;
    private PacoteViagem pacote;
    private LocalDate dataCompra;


    public Compra(Turista turista, PacoteViagem pacote) {
        this.turista = turista;
        this.pacote = pacote;
        this.dataCompra = LocalDate.now(); // Data da compra é o dia atual
    }


    public Turista getTurista() {
        return turista;
    }

    public PacoteViagem getPacote() {
        return pacote;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public String descreverCompra() {
        return "Turista: " + turista.getNome() + ", Pacote: " + pacote.descreverPacote() + ", Data: " + dataCompra;
    }
}
