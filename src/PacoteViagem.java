public class PacoteViagem {
    private String tipo; // Pode ser "Nacional" ou "Internacional"
    private String destino; // Destino do pacote de viagem
    private int duracao; // Duração em dias
    private String nivel; // Nível do pacote: "Completo", "Luxo", "Standard"

    // Construtor
    public PacoteViagem(String tipo, String destino, int duracao, String nivel) {
        this.tipo = tipo;
        this.destino = destino;
        this.duracao = duracao;
        this.nivel = nivel;
    }

    // Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    // Método para descrever o pacote de viagem
    public String descreverPacote() {
        return "Pacote " + tipo + " para " + destino + " com duração de " + duracao + " dias. Nível: " + nivel;
    }
}
