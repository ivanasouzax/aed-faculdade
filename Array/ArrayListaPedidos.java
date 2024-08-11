public class ArrayListaPedidos{
    private Array pedidos;
    private int tamanho;

    public ArrayListaPedidos(int capacidadeInicial) {
        pedidos = new Array(capacidadeInicial);
        tamanho = 0;
   }
    public void add(Pedido p) {
        if (tamanho == pedidos.getLength()) {
            pedidos.setLength(pedidos.getLength() * 2);
        }
        pedidos.setElemento(tamanho + 1, p); 
        tamanho++;
    }

    public Pedido remover(int codigoPedido) {
        for (int i = 1; i <= tamanho; i++) {
            Pedido p = (Pedido) pedidos.getElemento(i);
            if (p.getCodigoPedido() == codigoPedido) {
                Pedido removido = p;
                for (int j = i; j < tamanho; j++) {
                    pedidos.setElemento(j, pedidos.getElemento(j + 1));
                }
                pedidos.setElemento(tamanho, null);
                tamanho--;
                return removido;
            }
        }
        return null;
    }
    
    public Pedido pesquisar(int codigoPedido) {
        for (int i = 1; i <= tamanho; i++) {
            Pedido p = (Pedido) pedidos.getElemento(i);
            if (p.getCodigoPedido() == codigoPedido) {
                return p;
            }
        }
        return null;
    }

     public String toString() {
        StringBuilder resultado = new StringBuilder();
        for (int i = 1; i <= tamanho; i++) {
            Pedido p = (Pedido) pedidos.getElemento(i);
            resultado.append("\n").append(p.toString());
        }
        return resultado.toString();
    }

    public void inserirAntes(int codigoPedido, Pedido p) {
        for (int i = 1; i <= tamanho; i++) {
            Pedido pedidoAtual = (Pedido) pedidos.getElemento(i);
            if (pedidoAtual.getCodigoPedido() == codigoPedido) {
                if (tamanho == pedidos.getLength()) {
                    pedidos.setLength(pedidos.getLength() * 2);
                }
                for (int j = tamanho; j >= i; j--) {
                    pedidos.setElemento(j + 1, pedidos.getElemento(j));
                }
                pedidos.setElemento(i, p);
                return;
            }
        }
    }

    public void inserirDepois(int codigoPedido, Pedido p) {
        for (int i = 1; i <= tamanho; i++) {
            Pedido pedidoAtual = (Pedido) pedidos.getElemento(i);
            if (pedidoAtual.getCodigoPedido() == codigoPedido) {
                if (tamanho == pedidos.getLength()) {
                    pedidos.setLength(pedidos.getLength() * 2);
                }
                for (int j = tamanho; j > i; j--) {
                    pedidos.setElemento(j + 1, pedidos.getElemento(j));
                }
                pedidos.setElemento(i + 1, p);
                tamanho++;
                return;
            }
        }
    }
  
}

