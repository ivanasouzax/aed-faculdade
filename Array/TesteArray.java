import java.util.Date;

public class TesteArray{

		public static void main (String[] args) {
			
			//Criar um novo cliente e adicioná-lo à lista de clientes.
			Cliente c1 = new Cliente("João", "Rua cruzeiro" , "77 8888-4444", new Date(), new Date(), new Date());
			Cliente c2 = new Cliente("Ivana", "Rua primavera" , "77 8888-4444", new Date(), new Date(), new Date());
			
			ArrayListaCliente lciente = new ArrayListaCliente(2);
			lciente.add(c1);
			lciente.add(c2);
			
			System.out.println(lciente.toString());

			//Pesquisar um cliente pelo nome e exibir os dados do mesmo.
            Cliente cpesquisado = lciente.pesquisar("João");
            System.out.println("Cliente pesquisado = " + cpesquisado.toString() +"\n");

			 //Teste pedidos

			 Pedido p1 = new Pedido(111, new Date(), c1);
			 Pedido p2 = new Pedido(222, new Date(), c2);

			 ArrayListaPedidos lpedidos = new ArrayListaPedidos(2);

			 lpedidos.add(p1);
			 lpedidos.add(p2);

			 System.out.println(lpedidos.pesquisar(111));
            
	}
}

