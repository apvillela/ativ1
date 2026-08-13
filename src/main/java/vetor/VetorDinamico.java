package vetor;

public class VetorDinamico {

    private String[] elementos;
    int tamanho;

    public VetorDinamico(int quantidade) {
        elementos = new String[quantidade];
        tamanho = 0;
    }

    private void expandir() {
        String[] novo = new String[elementos.length * 2];
        for (int i = 0; i < elementos.length; i++) {
            novo[i] = elementos[i];
        }
        elementos = novo;
    }

    public void inserir(String elemento) {
        if (tamanho == elementos.length) {
            expandir();
        }
        elementos[tamanho] = elemento;
        tamanho++;
    }


}
