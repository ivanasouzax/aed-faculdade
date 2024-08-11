public class ListaEncadeadaPedidos {
    private  ListaDuplamenteEncadeada<Pedido> pedidos;

    public ListaEncadeadaPedidos() {
        pedidos = new ListaDuplamenteEncadeada<>();
   }
    public void add(Pedido p) {
        pedidos.inserirFim(p);
    }

    public Pedido remover(int codigoPedido) {
        ListaDuplamenteEncadeada<Pedido>.Element<Pedido> current = pedidos.getHead();
        while (current != null) {
            if (current.getData().getCodigoPedido() == codigoPedido) { 
                try {
                    Pedido pedido = current.getData();
                    pedidos.remover(pedido);
                    return pedido;
                } catch (ObjetoNaoEncontradoException e) {
                    e.printStackTrace();
                }
            }
            current = current.getNext();
        }
        return null;
    }
    
    
    public Pedido pesquisar(int codigoPedido) {
        ListaDuplamenteEncadeada<Pedido>.Element<Pedido> current = pedidos.getHead();
        while (current != null) {
            do{
              if (current.getData().getCodigoPedido() == codigoPedido) {
                return current.getData();
            }
            current = current.getNext();
        } while (current != pedidos.getHead());
     }
        return null;
    }

     public String toString() {
        ListaDuplamenteEncadeada<Pedido>.Element<Pedido> current = pedidos.getHead();
        StringBuilder resultado = new StringBuilder();
        while (current != null) {
            resultado.append("\n").append(current.getData().toString());
            current = current.getNext();
        }
		return resultado.toString(); 
     }

      public void inserirAntes(int referenciaCodigo, Pedido c) {
        ListaDuplamenteEncadeada<Pedido>.Element<Pedido> current = pedidos.getHead();
        while (current != null) {
            if (current.getData().getCodigoPedido() == referenciaCodigo) {
                ListaDuplamenteEncadeada<Pedido>.Element<Pedido> novoElemento =
                        pedidos.new Element<>(c, current.getPrev(), current);
                if (current.getPrev() != null) {
                    current.getPrev().setNext(novoElemento);
                } else {
                    pedidos.setHead(novoElemento);
                }
                current.setPrev(novoElemento);
                return;
            }
            current = current.getNext();
        }
    }

    public void inserirDepois(int referenciaCodigo, Pedido c) {
        ListaDuplamenteEncadeada<Pedido>.Element<Pedido> current = pedidos.getHead();
        while (current != null) {
            if (current.getData().getCodigoPedido() == referenciaCodigo) {
                ListaDuplamenteEncadeada<Pedido>.Element<Pedido> novoElemento =
                        pedidos.new Element<>(c, current, current.getNext());
                if (current.getNext() != null) {
                    current.getNext().setPrev(novoElemento);
                } else {
                    pedidos.setTail(novoElemento);
                }
                current.setNext(novoElemento);
                return;
            }
            current = current.getNext();
        }
    }
}

