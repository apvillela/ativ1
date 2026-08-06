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
            System.out.println("Vetor cheio");
            return;
        }
        if (indice < 0 || indice > tamanho) {
            System.out.println("posição inválida");
            return;
        }
        for (int i = tamanho; i > indice; i--) {
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
            System.out.println("Vetor vazio");
        } else {
            elementos[tamanho - 1] = null;
            tamanho--;
        }
    }
    public void remover(int indice) {
        if (tamanho == 0) {
            System.out.println("Vetor vazio");
        } else {
            elementos[tamanho - 1] = null;
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
            System.out.print(elementos[i]);
            if (i < elementos.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

    }

}
