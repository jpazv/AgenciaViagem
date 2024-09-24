import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {
    private List<Funcionario> funcionarios;

    public FuncionarioController() {
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("Funcionário adicionado com sucesso!");
    }

    public Funcionario buscarFuncionarioPorLogin(String login) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getLogin().equalsIgnoreCase(login)) {
                return funcionario;
            }
        }
        System.out.println("Funcionário com login '" + login + "' não encontrado.");
        return null;
    }

    public void atualizarSenhaFuncionario(String login, String novaSenha) {
        Funcionario funcionario = buscarFuncionarioPorLogin(login);
        if (funcionario != null) {
            funcionario.setSenha(novaSenha);
            System.out.println("Senha atualizada com sucesso para o funcionário " + funcionario.getNome());
        } else {
            System.out.println("Funcionário não encontrado para atualizar a senha.");
        }
    }

    public void removerFuncionario(String login) {
        Funcionario funcionario = buscarFuncionarioPorLogin(login);
        if (funcionario != null) {
            funcionarios.remove(funcionario);
            System.out.println("Funcionário removido com sucesso!");
        } else {
            System.out.println("Funcionário com login '" + login + "' não encontrado.");
        }
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
