package atividade.escalonador;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Processo[] processos = {
            new Processo("P1", 7, 0),
            new Processo("P2", 4, 0),
            new Processo("P3", 5, 1),
            new Processo("P4", 6, 2),
            new Processo("P5", 3, 4)
        };

        new Escalonador(processos).executar();
    }
}
