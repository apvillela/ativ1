package ads.esd;

public class Gerente {
    private String nome;
    private double salario_base;

    private double salario_final;
    private int projeto_finalizados;

    public double calcula_salario_final(){
        double salario_final_calculado = salario_base * (projeto_finalizados * 0.10);
        return salario_final_calculado;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario_base() {
        return salario_base;
    }

    public void setSalario_base(double salario_base) {
        this.salario_base = salario_base;
    }

    public double getSalario_final() {
        return salario_final;
    }

    public void setSalario_final(double salario_final) {
        this.salario_final = salario_final;
    }
}
