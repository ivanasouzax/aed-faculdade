public class ListaSimplesCliente {
    private ListaSimples<Cliente> clientes;

    public ListaSimplesCliente() {
        clientes = new ListaSimples<>();
    }

    public void add(Cliente c) {
        clientes.inserirFim(c);
    }

    public Cliente remover(String nomecliente) {
        try {
            ListaSimples<Cliente>.Element<Cliente> ptr = clientes.getHead();
            while (ptr != null) {
                if (ptr.getData().getNome().equals(nomecliente)) {
                    Cliente clienteRemovido = ptr.getData();
                    clientes.extrair(clienteRemovido);
                    return clienteRemovido;
                }
                ptr = ptr.getNext();
            }
        } catch (ObjetoNaoEncontradoException e) {
            return null;
        }
        return null;
    }

    public Cliente pesquisar(String nomecliente) {
        ListaSimples<Cliente>.Element<Cliente> ptr = clientes.getHead();
        while (ptr != null) {
            if (ptr.getData().getNome().equals(nomecliente)) {
                return ptr.getData();
            }
            ptr = ptr.getNext();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        ListaSimples<Cliente>.Element<Cliente> ptr = clientes.getHead();
        while (ptr != null) {
            resultado.append("\n").append(ptr.getData().toString());
            ptr = ptr.getNext();
        }
        return resultado.toString();
    }
}
