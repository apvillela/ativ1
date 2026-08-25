package vetor.teste;

import vetor.Vetor;

import java.util.Random;

public class Ex2VetorAleatorioOrdenado {

    public static Vetor<Integer> preencherVetor(Vetor<Integer> vetor, int quantidade, int range) {
        if (range < quantidade) {
            System.out.println("Range menor que a quantidade de sorteios");
            return vetor;
        }

        Random random = new Random();
        while (vetor.obterTamanho() < quantidade) {
            int sorteado = random.nextInt(range);
            if (!vetor.contem(sorteado)) {
                vetor.inserirOrdenado(sorteado);
            }
        }
        return vetor;
    }
}
