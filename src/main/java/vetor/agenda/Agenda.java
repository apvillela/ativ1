package vetor.agenda;

public class Agenda {

    private Contato[] contatos;
    private int tamanho;

    public Agenda(int capacidade) {
        contatos = new Contato[capacidade];
        this.tamanho = 0;
    }

    // retorna a posição do contato, ou -1 se não existir
    public int indiceDeNome(String nome) {
        for (int i = 0; i < tamanho; i++) {//for que percorre o tamanho da agenda,
            if (contatos[i].getNome().equals(nome)) {// se a posição da agenda tiver um contato com nome igual
                return i;//retorna a posição
            }
        }
        return -1;
    }

    public int indiceDeTelefone(String telefone) {
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getTelefone().equals(telefone)) {
                return i;
            }
        }
        return -1;
    }

    public void adicionarContato(Contato contato) {
        if (tamanho >= contatos.length) {
            System.out.println("Agenda cheia");
            return;
        }
        if (indiceDeNome(contato.getNome()) != -1) {
            System.out.println("Nome já cadastrado");
            return;
        }
        if (indiceDeTelefone(contato.getTelefone()) != -1) {
            System.out.println("Telefone já cadastrado");
            return;
        }
        contatos[tamanho] = contato;//bota no fim
        tamanho++;
        System.out.println("cadastro realizado com sucesso");
    }

    public void removerContato(String nome) {
        int indice = indiceDeNome(nome);
        if (indice == -1) {
            System.out.println("Contato não encontrado");
            return;
        }
        for (int i = indice; i < tamanho - 1; i++) {
            contatos[i] = contatos[i + 1];
        }
        contatos[tamanho - 1] = null;
        tamanho--;
    }

    public Contato buscarPorNome(String nome) {
        int indice = indiceDeNome(nome);
        if (indice == -1) {
            return null;
        }
        return contatos[indice];
    }

    public Contato buscarPorTelefone(String telefone) {
        int indice = indiceDeTelefone(telefone);
        if (indice == -1) {
            return null;
        }
        return contatos[indice];
    }

    public void atualizarContato(String nome, String novoTelefone, String novoEmail) {
        int indice = indiceDeNome(nome);
        if (indice == -1) {
            System.out.println("Contato não encontrado");
            return;
        }
        contatos[indice].setTelefone(novoTelefone);
        contatos[indice].setEmail(novoEmail);
    }

    public Contato[] buscarPorPrefixo(String prefixo) {
        int quantidade = 0;
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().startsWith(prefixo)) {
                quantidade++;
            }
        }
        Contato[] encontrados = new Contato[quantidade];
        int posicao = 0;
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().startsWith(prefixo)) {
                encontrados[posicao] = contatos[i];
                posicao++;
            }
        }
        return encontrados;
    }

    public void listarContatos() {
        System.out.print("[");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(contatos[i]);
            if (i < tamanho - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public void inserirEmLote(Contato[] novos){
        for (Contato contato : novos){
            if(contato!= null)
                adicionarContato(contato);
        }
    }

}
