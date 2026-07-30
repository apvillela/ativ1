package ads.esd;

public class Funcionario {
    private String name;
    private Integer salario_base;

    public Funcionario(String name, Integer salario_base) {
        this.salario_base = salario_base;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "name='" + name + '\'' +
                ", salario_base=" + salario_base +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalario_base() {
        return salario_base;
    }

    public void setSalario_base(Integer salario_base) {
        this.salario_base = salario_base;
    }

}
