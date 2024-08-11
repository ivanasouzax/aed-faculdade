public class ListaEncadeadaCliente {
    private ListaDuplamenteEncadeada<Cliente> clientes;

    public ListaEncadeadaCliente() {
        clientes = new ListaDuplamenteEncadeada<>();
    }

    public void add(Cliente c) {
        clientes.inserirFim(c);
    }

    public Cliente remover(String nomecliente) {
        ListaDuplamenteEncadeada<Cliente>.Element<Cliente> current = clientes.getHead();
        while (current != null) {
            if (current.getData().getNome().equals(nomecliente)) {
                try {
                    Cliente cliente = current.getData();
                    clientes.remover(cliente);
                    return cliente;
                } catch (ObjetoNaoEncontradoException e) {
                    e.printStackTrace();
                }
            }
            current = current.getNext();
        }
        return null;
    }

    public String toString() {
        ListaDuplamenteEncadeada<Cliente>.Element<Cliente> current = clientes.getHead();
        StringBuilder resultado = new StringBuilder();
        while (current != null) {
            resultado.append("\n").append(current.getData().toString());
            current = current.getNext();
        }
        return resultado.toString();
    }

    public Cliente pesquisar(String nomecliente) {
        ListaDuplamenteEncadeada<Cliente>.Element<Cliente> current = clientes.getHead();
        while (current != null) {
            if (current.getData().getNome().equals(nomecliente)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    public void inserirAntes(String referenciaNome, Cliente c) {
        ListaDuplamenteEncadeada<Cliente>.Element<Cliente> current = clientes.getHead();
        while (current != null) {
            if (current.getData().getNome().equals(referenciaNome)) {
                ListaDuplamenteEncadeada<Cliente>.Element<Cliente> novoElemento =
                        clientes.new Element<>(c, current.getPrev(), current);
                if (current.getPrev() != null) {
                    current.getPrev().setNext(novoElemento);
                } else {
                    clientes.setHead(novoElemento);
                }
                current.setPrev(novoElemento);
                return;
            }
            current = current.getNext();
        }
    }

    public void inserirDepois(String referenciaNome, Cliente c) {
        ListaDuplamenteEncadeada<Cliente>.Element<Cliente> current = clientes.getHead();
        while (current != null) {
            if (current.getData().getNome().equals(referenciaNome)) {
                ListaDuplamenteEncadeada<Cliente>.Element<Cliente> novoElemento =
                        clientes.new Element<>(c, current, current.getNext());
                if (current.getNext() != null) {
                    current.getNext().setPrev(novoElemento);
                } else {
                    clientes.setTail(novoElemento);
                }
                current.setNext(novoElemento);
                return;
            }
            current = current.getNext();
        }
    }
}
