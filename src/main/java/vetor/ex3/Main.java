package vetor.ex3;

import vetor.agenda.Contato;

import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
    static final AgendaArray agenda = new AgendaArray();

    static void main(String[] args) {
        boolean rodando = true;

        while (rodando) {
            imprimirMenu();

            switch (lerOpcao()) {
                case 1 -> adicionarContato();
                case 2 -> removerContato();
                case 3 -> buscarContato();
                case 4 -> atualizarContato();
                case 5 -> rodando = false;
                default -> System.out.println("Opcao invalida.");
            }
        }

        System.out.println("Encerrando a agenda.");
    }

    static void imprimirMenu() {
        System.out.println("""
                
                --- MENU DA AGENDA DE CONTATOS ---
                1 - Adicionar Contato (Ordenado)
                2 - Remover Contato
                3 - Buscar Contato
                4 - Atualizar Contato
                5 - Sair""");
        System.out.print("Escolha uma opcao:");
    }

    static int lerOpcao() {
        String linha = scanner.nextLine();
        if (!linha.matches("\\d+")) {
            return -1;
        }
        return Integer.parseInt(linha);
    }

    static void adicionarContato() {
        System.out.print("Digite o nome do contato: ");
        String nome = scanner.nextLine();

        int indice = agenda.indiceDaLetra(nome);
        if (indice < 0) {
            System.out.println("Nome invalido, precisa comecar com uma letra de A a Z.");
            return;
        }

        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();

        boolean primeiroDaLetra = agenda.quantidadeNaLetra(indice) == 0;
        agenda.inserirContatoOrdenadoNoVetor(new Contato(nome, telefone));

        String acao = primeiroDaLetra ? "adicionado com sucesso" : "inserido ordenadamente";
        System.out.println("Contato '" + nome + "' " + acao
                + " na letra '" + letraDe(nome) + "' (Indice " + indice + ")!");
    }

    static void removerContato() {
        System.out.print("Digite o nome do contato a remover: ");
        String nome = scanner.nextLine();

        if (!agenda.removerContato(nome)) {
            System.out.println("Contato nao encontrado.");
            return;
        }

        System.out.println("Contato '" + nome + "' removido com sucesso do Vetor '" + letraDe(nome) + "'!");
    }

    static void buscarContato() {
        System.out.print("Digite o nome do contato a buscar: ");
        String nome = scanner.nextLine();

        Contato encontrado = agenda.buscaContato(nome);
        if (encontrado == null) {
            System.out.println("Contato nao encontrado.");
            return;
        }

        System.out.println("Contato encontrado no Vetor '" + letraDe(nome) + "': "
                + encontrado.getNome() + ", Telefone: " + encontrado.getTelefone());
    }

    static void atualizarContato() {
        System.out.print("Digite o nome do contato a atualizar: ");
        String nome = scanner.nextLine();

        Contato existente = agenda.buscaContato(nome);
        if (existente == null) {
            System.out.println("Contato nao encontrado.");
            return;
        }

        System.out.print("Digite o novo telefone: ");
        existente.setTelefone(scanner.nextLine());

        System.out.println("Contato '" + existente.getNome() + "' atualizado com sucesso!");
    }

    static char letraDe(String nome) {
        return Character.toUpperCase(nome.charAt(0));
    }
}
