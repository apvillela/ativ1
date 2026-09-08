package vetor.ex3;

import vetor.Vetor;
import vetor.agenda.Contato;

public class AgendaArray {
    private Vetor<Contato>[] agenda;

    @SuppressWarnings("unchecked")
    public AgendaArray() {
        agenda = new Vetor[26];
        for (int i = 0; i < agenda.length; i++) {
            agenda[i] = new Vetor<>(10);
        }
    }

    void inserirContatoOrdenadoNoVetor(Contato contato) {
        int indiceParaInserir = indiceDaLetra(contato.getNome());
        if (indiceParaInserir < 0) {
            System.out.println("Nome inválido");
            return;
        }
        agenda[indiceParaInserir].inserirOrdenado(contato);
    }

    public Contato buscaContato(String nome) {
        int indice = indiceDaLetra(nome);
        if (indice < 0) {
            return null;
        }
        Vetor<Contato> letra = agenda[indice];
        for (int i = 0; i < letra.obterTamanho(); i++) {
            if (letra.obter(i).getNome().equalsIgnoreCase(nome)) {
                return letra.obter(i);
            }
        }
        return null;
    }

    public boolean removerContato(String nome) {
        int indice = indiceDaLetra(nome);
        if (indice < 0) {
            return false;
        }
        Vetor<Contato> letra = agenda[indice];
        for (int i = 0; i < letra.obterTamanho(); i++) {
            if (letra.obter(i).getNome().equalsIgnoreCase(nome)) {
                letra.remover(i);
                return true;
            }
        }
        return false;
    }

    int indiceDaLetra(String nome) {
        if (nome == null || nome.isBlank()) {
            return -1;
        }
        char inicial = nome.charAt(0);
        int indice = Character.toUpperCase(inicial) - 'A';
        if (indice < 0 || indice > 25) {
            return -1;
        }
        return indice;
    }

    int quantidadeNaLetra(int indice) {
        if (indice < 0 || indice >= agenda.length) {
            return 0;
        }
        return agenda[indice].obterTamanho();
    }
}
