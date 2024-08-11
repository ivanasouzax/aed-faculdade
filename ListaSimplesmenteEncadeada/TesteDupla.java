import java.util.Date;

public class TesteDupla {

		public static void main (String[] args) {
			
			//Criar um novo cliente e adicioná-lo à lista de clientes.
			Cliente c1 = new Cliente("João", "Rua cruzeiro" , "77 8888-4444", new Date(), new Date(), new Date());
			Cliente c2 = new Cliente("Ivana", "Rua primavera" , "77 8888-4444", new Date(), new Date(), new Date());
			
			ListaSimplesCliente lciente = new ListaSimplesCliente();

			lciente.add(c1);
			lciente.add(c2);
			
			System.out.println(lciente.toString());

			System.out.println(lciente.pesquisar("João"));

			ListaSimplesPedidos lpedidos = new ListaSimplesPedidos(); 

			 Pedido p1 = new Pedido(111, new Date(), c1);
			 Pedido p2 = new Pedido(222, new Date(), c2);

			 lpedidos.add(p1); 
			 lpedidos.add(p2);

			 System.out.println(lpedidos.pesquisar(111));
	}
}

