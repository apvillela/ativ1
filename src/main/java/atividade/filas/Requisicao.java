package atividade.filas;

import java.util.UUID;

public class Requisicao implements Comparable<Requisicao> {
    private UUID requestId;

    public Requisicao() {
        requestId = UUID.randomUUID();
    }

    public UUID getRequestId() {
        return requestId;
    }

    @Override
    public int compareTo(Requisicao o) {
        return requestId.compareTo(o.requestId);
    }

    @Override
    public String toString() {
        return requestId.toString().substring(0, 8);
    }
}
