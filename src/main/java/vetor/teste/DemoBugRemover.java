package vetor.teste;

import vetor.Vetor;

public class DemoBugRemover {

    static void main() {
        Vetor<Integer> vetor = new Vetor<>(2);
        vetor.inserir(10);
        vetor.inserir(20);

        System.out.print("antes:   ");
        vetor.imprimir();

        // o bug antigo estourava aqui, com o vetor exatamente cheio (tamanho == length)
        vetor.remover(0);
        System.out.print("depois:  ");
        vetor.imprimir();
    }
}
