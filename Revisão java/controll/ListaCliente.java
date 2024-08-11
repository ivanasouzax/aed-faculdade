import java.util.*;

public class ListaCliente {
	private List<Cliente> clientes; 
	
	public ListaCliente() {
		 clientes = new LinkedList<>();
	}
	
	public void add(Cliente c) {
		clientes.add(c);
	}
	
	public Cliente remover(String nomecliente) {
		Cliente c;
		int s = clientes.size();
		for( int i = 0; i<s; i++) {
			c = clientes.get(i);
			if (c.getNome().equals(nomecliente));{
				return clientes.remove(i);
			}
		}
		
		return null; 
     }
	
	public String toString() {
		Cliente c; 
		String resultado ="";
		int s = clientes.size();
		for (int i = 0; i <s; i++) {
			c = clientes.get(i); 
			resultado = resultado + "\n" + c.toString();
		}
		
		return resultado; 
		
	}
	
	public Cliente pesquisar(String nomecliente) {
		Cliente c;
		int s = clientes.size();
		for (int i=0; i<s; i++) {
			c = clientes.get(i);
			if (c.getNome().equals(nomecliente)) {
				return clientes.get(i);
			}
		}
		
		return null; 
	}
}
