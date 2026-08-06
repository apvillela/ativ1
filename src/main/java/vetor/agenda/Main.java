package vetor.agenda;

public class Main {

    static void main() {
        Agenda agenda = new Agenda(5);

        agenda.adicionarContato(new Contato("aaaa", "312312", "aaaa@gmail.com"));
        agenda.adicionarContato(new Contato("bbbbbb", "332131212"));
        agenda.adicionarContato(new Contato("sadsadsa", "111111"));
        agenda.adicionarContato(new Contato("duhsahdua", "222222"));

        agenda.adicionarContato(new Contato("aaaa", "413131"));

        agenda.listarContatos();

        System.out.println(agenda.buscarPorNome("bbbbbb"));
        System.out.println(agenda.buscarPorTelefone("111111"));

        agenda.atualizarContato("bbbbbb", "99999", "bbbbbb@gmail.com");
        System.out.println(agenda.buscarPorNome("bbbbbb"));

        for (Contato contato : agenda.buscarPorPrefixo("aa")) {
            System.out.println(contato);
        }

        agenda.removerContato("sadsadsa");
        agenda.listarContatos();
    }
}
