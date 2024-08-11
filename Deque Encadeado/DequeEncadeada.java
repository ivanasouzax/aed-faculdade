public class DequeEncadeada implements Deque {
    private ListaSimples lista;

    public DequeEncadeada() {
        lista = new ListaSimples();
    }

    @Override
    public void fazVazia() {
        lista.fazVazia();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public Object getPrimeiro() {
        if (estaVazia()) {
            throw new ContainerVazioException("Deque vazio.");
        }
        return lista.getHead().data;
    }

    @Override
    public Object getUltimo() {
        if (estaVazia()) {
            throw new ContainerVazioException("Deque vazio.");
        }
        return lista.getTail().data;
    }

    @Override
    public void enfileirarInicio(Object objeto) {
        lista.inserirInicio(objeto);
    }

    @Override
    public void enfileirarFim(Object objeto) {
        lista.inserirFim(objeto);
    }

    @Override
    public Object desenfileirarInicio() {
        if (estaVazia()) {
            throw new ContainerVazioException("Deque vazio.");
        }
        Object data = lista.getHead().data;
        try {
            lista.extrair(data);
        } catch (ObjetoNaoEncontradoException e) {
            // Este caso não deve ocorrer porque já verificamos se está vazio.
        }
        return data;
    }

    @Override
    public Object desenfileirarFim() {
        if (estaVazia()) {
            throw new ContainerVazioException("Deque vazio.");
        }
        Object data = lista.getTail().data;
        try {
            lista.extrair(data);
        } catch (ObjetoNaoEncontradoException e) {
            // Este caso não deve ocorrer porque já verificamos se está vazio.
        }
        return data;
    }

    public int getCount() {
        return lista.getCount();
    }
}
