import java.util.ArrayList;
import java.util.List;

public class Turista {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private int telefone;
    private String endereco;
    private String login;
    private String senha;
    private List<PacoteViagem> pacotes;
    private List<Pagamento> pagamentos; // Adicionando lista de pagamentos

    private static int idCounter = 1; // Contador para gerar IDs únicos

    // Construtor
    public Turista(String nome, String cpf, String email, int telefone, String endereco, String login, String senha) {
        this.id = idCounter++;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.login = login;
        this.senha = senha;
        this.pacotes = new ArrayList<>();
        this.pagamentos = new ArrayList<>(); // Inicializar a lista de pagamentos
    }

    // Métodos para adicionar e remover pacotes
    public void adicionarPacote(PacoteViagem pacote) {
        pacotes.add(pacote);
    }

    // Métodos para adicionar e remover pagamentos
    public void adicionarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    public void removerPagamento(Pagamento pagamento) {
        pagamentos.remove(pagamento);
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<PacoteViagem> getPacotes() {
        return pacotes;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }
}
