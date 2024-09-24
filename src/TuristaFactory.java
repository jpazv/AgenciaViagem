public class TuristaFactory {

    public static Turista criarTurista(String nome, String cpf, String email, int telefone, String endereco, String login, String senha) {
        return new Turista(nome, cpf, email, telefone, endereco, login, senha);
    }
}
