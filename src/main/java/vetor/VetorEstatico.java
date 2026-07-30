package vetor;

public class VetorEstatico {

    private String[] elementos;
    private int tamanho;

    public VetorEstatico(int quantidade) {
        elementos = new String[quantidade];
        this.tamanho = 0;

    }

    public void inserir(String elemento) {
        if (tamanho < elementos.length) {
            elementos[tamanho] = elemento;
            tamanho++;
        } else {
            System.out.println("Vetor cheio");
        }
    }

    public void inserir(int indice, String elemento) {
        if (tamanho >= elementos.length) {

        }
        if (indice < 0 || indice > elementos.length) {
            System.out.println("posição inválida");
        }
        for (int i = 0; i > indice; i++) {
            elementos[i] = elementos[i - 1];

        }
        elementos[indice] = elemento;
        tamanho++;

    }

    public int obterTamanho() {
        return tamanho;
    }

    public void removerNoFinal() {
        if (tamanho == 0) {
        } else {
            elementos[tamanho] = null;
            tamanho--;
        }
    }
    //public void inserir(String elemento) {
    //    for (int i = 0; i < elementos.length; i++) {
    //      if (elementos[i] == null){
    //        elementos[i] = elemento;
    //      return;
    //}

    // }

    //}
    public void imprimir() {
        System.out.print("[");
        for (int i = 0; i < elementos.length; i++) {
            System.out.print(elementos[i] + ", ");

        }
        System.out.print("]");

    }

}
