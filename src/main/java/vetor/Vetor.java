package vetor;

public class Vetor<T extends Comparable<T>> {

    private T[] elementos;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public Vetor(int quantidade) {
        elementos = (T[]) new Comparable[quantidade];
        this.tamanho = 0;
    }

    // retorna a posição do elemento, ou -1 se não existir
    public int indiceDe(T elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contem(T elemento) {
        return indiceDe(elemento) != -1;
    }

    public void inserir(T elemento) {
        if (tamanho == elementos.length) {
            expandir();
        }
        elementos[tamanho] = elemento;
        tamanho++;
    }

    public void inserirNaPosicao(int indice, T elemento) {
        if (indice < 0 || indice > tamanho) {
            System.out.println("Posição inválida");
            return;
        }
        if (tamanho == elementos.length) {
            expandir();
        }
        for (int i = tamanho; i > indice; i--) {
            elementos[i] = elementos[i - 1];
        }
        elementos[indice] = elemento;
        tamanho++;
    }

    public void inserirOrdenado(T elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elemento.compareTo(elementos[i]) < 0) {
                inserirNaPosicao(i, elemento);
                return;
            }
        }
        inserir(elemento);// maior que todos, vai pro fim
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

    @SuppressWarnings("unchecked")
    private void expandir() {
        T[] novo = (T[]) new Comparable[Math.max(1, elementos.length * 2)];
        for (int i = 0; i < tamanho; i++) {
            novo[i] = elementos[i];
        }
        elementos = novo;
    }

    @SuppressWarnings("unchecked")
    private void reduzir() {
        if (tamanho > elementos.length / 4) {
            return;
        }
        T[] novo = (T[]) new Comparable[elementos.length / 2];
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
