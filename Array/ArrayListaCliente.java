public class ArrayListaCliente {
    private Array clientes;
    private int tamanho;

    public ArrayListaCliente(int capacidadeInicial) {
        clientes = new Array(capacidadeInicial);
        tamanho = 0;
    }

    public void add(Cliente c) {
        if (tamanho == clientes.getLength()) {
            clientes.setLength(clientes.getLength() * 2);
        }
        clientes.setElemento(tamanho + 1, c); 
        tamanho++;
    }

    public Cliente remover(String nomecliente) {
        for (int i = 1; i <= tamanho; i++) {
            Cliente c = (Cliente) clientes.getElemento(i);
            if (c.getNome().equals(nomecliente)) {
                Cliente removido = c;
                for (int j = i; j < tamanho; j++) {
                    clientes.setElemento(j, clientes.getElemento(j + 1));
                }
                clientes.setElemento(tamanho, null);
                tamanho--;
                return removido;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder resultado = new StringBuilder();
        for (int i = 1; i <= tamanho; i++) {
            Cliente c = (Cliente) clientes.getElemento(i);
            resultado.append("\n").append(c.toString());
        }
        return resultado.toString();
    }

    public Cliente pesquisar(String nomecliente) {
        for (int i = 1; i <= tamanho; i++) {
            Cliente c = (Cliente) clientes.getElemento(i);
            if (c.getNome().equals(nomecliente)) {
                return c;
            }
        }
        return null;
    }

    public void inserirAntes(String referenciaNome, Cliente c) {
        for (int i = 1; i <= tamanho; i++) {
            Cliente clienteAtual = (Cliente) clientes.getElemento(i);
            if (clienteAtual.getNome().equals(referenciaNome)) {
                if (tamanho == clientes.getLength()) {
                    clientes.setLength(clientes.getLength() * 2);
                }
                for (int j = tamanho; j >= i; j--) {
                    clientes.setElemento(j + 1, clientes.getElemento(j));
                }
                clientes.setElemento(i, c);
                tamanho++;
                return;
            }
        }
    }

    public void inserirDepois(String referenciaNome, Cliente c) {
        for (int i = 1; i <= tamanho; i++) {
            Cliente clienteAtual = (Cliente) clientes.getElemento(i);
            if (clienteAtual.getNome().equals(referenciaNome)) {
                if (tamanho == clientes.getLength()) {
                    clientes.setLength(clientes.getLength() * 2);
                }
                for (int j = tamanho; j > i; j--) {
                    clientes.setElemento(j + 1, clientes.getElemento(j));
                }
                clientes.setElemento(i + 1, c);
                tamanho++;
                return;
            }
        }
    }
}
