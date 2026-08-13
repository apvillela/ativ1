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
    }


}
