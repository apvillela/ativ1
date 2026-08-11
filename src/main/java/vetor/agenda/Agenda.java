package vetor.agenda;

public class Agenda {

    private Contato[] contatos;
    private int tamanho;

    public Agenda(int capacidade) {
        contatos = new Contato[capacidade];
        this.tamanho = 0;
    }

    public void adicionarContato(Contato contato) {
        if (tamanho >= contatos.length) {
            System.out.println("Agenda cheia");
             return;
        }
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().equals(contato.getNome())) {//bate o cntato querendo ser adicionado cm a agenda completa
                System.out.println("Nome já cadastrado");
                return;
            }
        }
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getTelefone().equals(contato.getTelefone())) {
                System.out.println("Telefone já cadastrado");
                return;
            }
        }
        contatos[tamanho] = contato;//bota no fim
        tamanho++;
        System.out.println("cadastro realizado com sucesso");
    }

    public void removerContato(String nome) {
        int indice = -1;
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().equals(nome)) {
                indice = i;
                break;
            }
        }
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
        for (int i = 0; i < tamanho; i++) {//for que percorre o tamanho da agenda,
            if (contatos[i].getNome().equals(nome)) {// se a posição da agenda tiver um contato com nome igual
                return contatos[i];//retorna o contato dessa posição
            }
        }
        return null;
    }

    public Contato buscarPorTelefone(String telefone) {
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getTelefone().equals(telefone)) {
                return contatos[i];
            }
        }
        return null;
    }

    public void atualizarContato(String nome, String novoTelefone, String novoEmail) {
        int indice = -1;
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().equals(nome)) {
                indice = i;

                break;
            }
        }
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
