import java.util.LinkedList;
import java.util.List;

public class ListaItensDoPedido {
	private List<ItemPedido> listaItensDoPedidos; 
	
	public ListaItensDoPedido () {
		listaItensDoPedidos = new LinkedList<>();
	}

    public List<ItemPedido> getListaItensDoPedido(){
        return listaItensDoPedidos;
    }

    public void add(ItemPedido p) {
        listaItensDoPedidos.add(p);
    }

    public ItemPedido remover(String nomeDoProduto) {
        ItemPedido p;
        int s = listaItensDoPedidos.size();
        for (int i = 0; i < s; i++) {
            p = listaItensDoPedidos.get(i);
            if (p.getNomeDoProduto() == nomeDoProduto) {
                listaItensDoPedidos.remove(i);
                return p;
            }
        }
        return null;
    }
    
    public ItemPedido pesquisarItemPedido(String nomeDoProduto) {
        ItemPedido p;
        int s = listaItensDoPedidos.size();
        for (int i = 0; i < s; i++) {
            p = listaItensDoPedidos.get(i);
            if (p.getNomeDoProduto() == nomeDoProduto) {
                return p;
            }
        }
        return null;
    }

    public double valortotalPedido(){
		double total = 0;
        for (ItemPedido ip : listaItensDoPedidos ) {
            total += ip.getSubtotal();
        }
        return total;
	}


    public String toString() {
		ItemPedido c; 
		String resultado ="";
		int s = listaItensDoPedidos.size();
		for (int i = 0; i <s; i++) {
			c = listaItensDoPedidos.get(i); 
			resultado = resultado + "\n" + c.toString();
		}
		
		return resultado; 
		
	}

}

