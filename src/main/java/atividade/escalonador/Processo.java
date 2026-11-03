package atividade.escalonador;

import java.sql.Time;
import java.sql.Timestamp;

public class Processo implements Comparable<Processo> {
    public String nome;
    public int instrucoesRestantes;
    public int tempoChegada;
    public Status statusAtual;


    public Processo(String nome, int quantidadeDeInstrucoes, int tempoChegada){
        this.nome = nome;
        this.instrucoesRestantes = quantidadeDeInstrucoes;
        this.tempoChegada = tempoChegada;
        setStatus(Status.AGUARDANDO);
    }

    public void setStatus(Status novoStatus) {
        this.statusAtual = novoStatus;
    }

    public Status getStatus() {
        return this.statusAtual;
    }

    @Override
    public int compareTo(Processo o) {
        return 0;
    }

    @Override
    public String toString() {
        return nome;
    }
}
