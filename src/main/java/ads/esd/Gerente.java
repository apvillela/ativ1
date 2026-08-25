package ads.esd;

public class Gerente {

    private String nome;
    private double salarioBase;
    private int projetosFinalizados;

    public double calcularSalarioFinal() {
        return salarioBase * (projetosFinalizados * 0.10);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getProjetosFinalizados() {
        return projetosFinalizados;
    }

    public void setProjetosFinalizados(int projetosFinalizados) {
        this.projetosFinalizados = projetosFinalizados;
    }

    @Override
    public String toString() {
        return "Gerente{ nome=" + nome + ", salarioBase=" + salarioBase + ", projetosFinalizados=" + projetosFinalizados + " }";
    }
}
