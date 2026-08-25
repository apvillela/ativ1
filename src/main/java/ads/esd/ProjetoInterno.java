package ads.esd;

import java.util.ArrayList;
import java.util.List;

public class ProjetoInterno {

    private List<Funcionario> funcionarios;
    private String nome;
    private Gerente gerente;
    private boolean finalizado;

    public ProjetoInterno(String nome, Gerente gerente) {
        this.nome = nome;
        this.gerente = gerente;
        this.funcionarios = new ArrayList<>();
        this.finalizado = false;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        if (funcionario == null) {
            System.out.println("Funcionário inválido");
            return;
        }
        funcionarios.add(funcionario);
    }

    public void finalizarProjeto() {
        finalizado = true;
    }

    public double calcularSalarioBruto() {
        double custoFuncionarios = 0;
        for (Funcionario funcionario : funcionarios) {
            custoFuncionarios += funcionario.getSalarioBase();
        }
        double salarioGerente = gerente.getSalarioBase() * (funcionarios.size() * 1.01);
        return salarioGerente + custoFuncionarios;
    }

    public double calcularCusto() {
        if (finalizado) {
            return calcularSalarioBruto();
        }
        return calcularSalarioBruto() * 1.1;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return "Projeto{ nome=" + nome + ", gerente=" + gerente.getNome() + ", funcionarios=" + funcionarios + ", custo=" + calcularCusto() + " }";
    }
}
