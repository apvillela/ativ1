package vetor;

public class VetorDinamico {

    private String[] elementos;
    private int tamanho;

    public VetorDinamico(int quantidade) {
        elementos = new String[quantidade];
        this.tamanho = 0;
    }

    public void inserir(String elemento) {
        if (tamanho == elementos.length) {
            expandir();
        }
        elementos[tamanho] = elemento;
        tamanho++;
    }

    public void remover(int indice) {
        if (indice < 0 || indice >= tamanho) {
            System.out.println("Índice inválido");
            return;
        }
        for (int i = indice; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        elementos[tamanho - 1] = null;
        tamanho--;
        reduzir();
    }

    public int obterTamanho() {
        return tamanho;
    }

    private void expandir() {
        String[] novo = new String[Math.max(1, elementos.length * 2)];
        for (int i = 0; i < tamanho; i++) {
            novo[i] = elementos[i];
        }
        elementos = novo;
    }

    private void reduzir() {
        if (tamanho > elementos.length / 4) {
            return;
        }
        String[] novo = new String[elementos.length / 2];
        for (int i = 0; i < tamanho; i++) {
            novo[i] = elementos[i];
        }
        elementos = novo;
    }

    public void imprimir() {
        System.out.print("[");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(elementos[i]);
            if (i < tamanho - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
