package ads.esd;

import static java.lang.IO.print;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //instancio um projeto interno usando arrays (precisa de um construtor que recebe gerente e funcionario)
        // rodo o metodo adicionar funcionarios
        //rodo o tostring que aparece as infos do projeto
        Gerente ramon = new Gerente();
        ramon.setNome("ramon");
        Funcionario villela = new Funcionario("villela",3100);
        Funcionario lucas = new Funcionario("lucas",3100);

        ProjetoInterno projeto = new ProjetoInterno("visualizador",ramon);
        projeto.add_funcionario(villela);
        projeto.add_funcionario(lucas);
        print(projeto.toString());

    }
}
