import java.util.*;

public class ListaPedidos {
    private List<Pedido> pedidos;

    public ListaPedidos() {
        pedidos = new LinkedList<>();
   }
    public void add(Pedido p) {
        pedidos.add(p);
    }

    public Pedido remover(int codigoPedido) {
        Pedido p;
        int s = pedidos.size();
        for (int i = 0; i < s; i++) {
            p = pedidos.get(i);
            if (p.getCodigoPedido() == codigoPedido) {
                pedidos.remove(i);
                return p;
            }
        }
        return null;
    }
    
    public Pedido pesquisarPedido(int codigoPedido) {
        Pedido p;
        int s = pedidos.size();
        for (int i = 0; i < s; i++) {
            p = pedidos.get(i);
            if (p.getCodigoPedido() == codigoPedido) {
                return p;
            }
        }
        return null;
    }

     public String toString() {
        Pedido c; 
	 	String resultado ="";
		int s = pedidos.size();
		for (int i = 0; i <s; i++) {
	 		c = pedidos.get(i); 
			resultado = resultado + "\n" + c.toString();
		}
		
		return resultado; 
     }	
  
}

