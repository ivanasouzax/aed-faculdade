public class ListaSimplesPedidos {
   private ListaSimples<Pedido> pedidos;


    public ListaSimplesPedidos() {
        pedidos = new ListaSimples<>();
   }
    public void add(Pedido p) {
        pedidos.inserirFim(p);
    }

    public Pedido remover(int codigoPedido) {
        try {
            ListaSimples<Pedido>.Element<Pedido> ptr = pedidos.getHead();
            if (ptr == null) return null;
            do {
                if (ptr.getData().getCodigoPedido() == codigoPedido) {
                    Pedido pedidoRemovido = ptr.getData();
                    pedidos.extrair(pedidoRemovido);
                    return pedidoRemovido;
                }
                ptr = ptr.getNext();
            } while (ptr != pedidos.getHead());
        } catch (ObjetoNaoEncontradoException e) {
            return null;
        }
        return null;
    }
    
    public Pedido pesquisar(int codigoPedido) {
        ListaSimples<Pedido>.Element<Pedido> ptr = pedidos.getHead();
        if (ptr != null) {
            do {
                if (ptr.getData().getCodigoPedido() == codigoPedido) {
                    return ptr.getData();
                }
                ptr = ptr.getNext();
            } while (ptr != pedidos.getHead());
        }
        return null;
    }

     @Override
     public String toString() {
        StringBuilder resultado = new StringBuilder();
        ListaSimples<Pedido>.Element<Pedido> ptr = pedidos.getHead();
        while (ptr != null) {
            resultado.append("\n").append(ptr.getData().toString());
            ptr = ptr.getNext();
        }
    
        return resultado.toString();
    }
}

