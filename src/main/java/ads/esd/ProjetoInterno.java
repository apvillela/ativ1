package ads.esd;

import java.util.ArrayList;
import java.util.List;

public class ProjetoInterno {

    private List<Funcionario> funcionarios;
    private String nome;
    private Gerente gerente;
    private boolean is_finalizado;
    public void add_funcionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }

    public double get_salarios_bruto(){
        double custo_salarios_funcionarios_final = 0;
        for (int i = 0; i < funcionarios.size(); i++) {
            custo_salarios_funcionarios_final += funcionarios.get(i).getSalario_base();
        }
        double salario_gerente = gerente.getSalario_base() * (funcionarios.size()*1.01);

        return salario_gerente+custo_salarios_funcionarios_final;
    }
    public double getCusto() {
        if (is_finalizado) {// extrair pra um método getsalariostotalbonus

            return get_salarios_bruto();
        }
        else {
            return get_salarios_bruto()* 1.1;
        }
    }

    public ProjetoInterno(String nome, Gerente gerente) {
        is_finalizado = false;
        this.gerente = gerente;
        this.nome = nome;
        this.funcionarios = new ArrayList<>();
    }
    public void finaliza_projeto(){
        is_finalizado = true;
    }

    @Override
    public String toString() {
        return "Projeto{ " + nome +
                " funcionarios=" + funcionarios.toString() +
                ", gerente=" + gerente.getNome() + "custo "+ getCusto() +
                '}';
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
