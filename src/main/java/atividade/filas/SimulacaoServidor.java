package atividade.filas;

import java.util.Random;

public class SimulacaoServidor {

    private static final int CAPACIDADE = 10;
    private static final int CICLOS = 20;

    public static void main(String[] args) {

        Random random = new Random();
        Fila<Requisicao> fila = new Fila<>(CAPACIDADE);
        int atendidas = 0;
        int rejeitadas = 0;

        for (int ciclo = 1; ciclo <= CICLOS; ciclo++) {
            System.out.println("--- ciclo " + ciclo);

            // chegam de 0 a 3 requisições por ciclo
            int chegadas = random.nextInt(4);
            for (int i = 0; i < chegadas; i++) {
                Requisicao req = new Requisicao();
                if (fila.isFull()) {
                    rejeitadas++;
                    System.out.println("503 - fila cheia, rejeitada " + req);
                } else {
                    fila.enfileirar(req);
                    System.out.println("chegou " + req);
                }
            }

            // o servidor atende uma requisição por ciclo
            if (!fila.isEmpty()) {
                Requisicao atendida = fila.desenfileirar();
                atendidas++;
                System.out.println("200 - atendida " + atendida);
            }
            fila.imprimir();
        }

        while (!fila.isEmpty()) {
            System.out.println("200 - atendida " + fila.desenfileirar());
            atendidas++;
        }

        System.out.println("Atendidas: " + atendidas + " | Rejeitadas: " + rejeitadas);
    }
}
