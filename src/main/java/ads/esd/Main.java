package ads.esd;

public class Main {

    static void main() {
        Gerente ramon = new Gerente();
        ramon.setNome("ramon");
        ramon.setSalarioBase(5000);

        ProjetoInterno projeto = new ProjetoInterno("visualizador", ramon);
        projeto.adicionarFuncionario(new Funcionario("villela", 3100));
        projeto.adicionarFuncionario(new Funcionario("lucas", 3100));

        System.out.println(projeto);

        projeto.finalizarProjeto();
        System.out.println(projeto);
    }
}
