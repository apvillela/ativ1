package atividade.escalonador;

public class Escalonador {
    private static final int QUANTUM = 2;

    private Processo[] processos;
    private FilaCircular<Processo> fila;
    private int tempo = 0;

    public Escalonador(Processo[] processos) {
        this.processos = processos;
        this.fila = new FilaCircular<>(processos.length);
    }

    public void executar() throws InterruptedException {
        int terminados = 0;
        verificarChegadas();

        while (terminados < processos.length) {
            if (fila.isEmpty()) {
                tempo++;
                verificarChegadas();
                continue;
            }

            Processo p = fila.desinfileirar();
            p.setStatus(Status.EXECUTANDO);
            System.out.println("t=" + tempo + " | " + p.nome + " executando...");

            for (int i = 0; i < QUANTUM && p.instrucoesRestantes > 0; i++) {
                p.instrucoesRestantes--;
                tempo++;
                verificarChegadas();
            }
            Thread.sleep(2000);

            if (p.instrucoesRestantes == 0) {
                p.setStatus(Status.TERMINADO);
                terminados++;
                System.out.println("t=" + tempo + " | " + p.nome + " TERMINADO");
            } else {
                // novos processos que chegaram durante o quantum entram antes do que foi interrompido
                p.setStatus(Status.AGUARDANDO);
                fila.enfileirar(p);
                System.out.println("t=" + tempo + " | " + p.nome + " pausado, restam " + p.instrucoesRestantes);
            }
            fila.imprimir();
        }
    }

    private void verificarChegadas() {
        for (Processo p : processos) {
            if (p.tempoChegada == tempo) {
                fila.enfileirar(p);
                System.out.println("t=" + tempo + " | " + p.nome + " chegou");
            }
        }
    }
}
