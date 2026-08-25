package vetor.teste;

import vetor.VetorEstatico;

public class Ex1 {

    static void main() {
        VetorEstatico vetorEstatico = new VetorEstatico(3);

        vetorEstatico.inserir("A");
        vetorEstatico.inserir("B");
        vetorEstatico.inserir("C");
        vetorEstatico.inserir("D");

        vetorEstatico.imprimir();
    }
}
