public class PacoteViagemFactory {

    public static PacoteViagem criarPacote(String tipoPacote, String destino, int duracao, String nivel) {
        switch (tipoPacote.toLowerCase()) {
            case "nacional":
                return new PacoteViagem("Nacional", destino, duracao, nivel);
            case "internacional":
                return new PacoteViagem("Internacional", destino, duracao, nivel);
            default:
                throw new IllegalArgumentException("Tipo de pacote desconhecido: " + tipoPacote);
        }
    }
}
