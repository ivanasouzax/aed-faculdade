import java.util.Date;

public class TesteCliente {

		public static void main (String[] args) {
			
			//Criar um novo cliente e adicioná-lo à lista de clientes.
			Cliente c1 = new Cliente("João", "Rua cruzeiro" , "77 8888-4444", new Date(), new Date(), new Date());
			Cliente c2 = new Cliente("Ivana", "Rua primavera" , "77 8888-4444", new Date(), new Date(), new Date());
			
			ListaCliente lciente = new ListaCliente();

			lciente.add(c1);
			lciente.add(c2);
			
			System.out.println(lciente.toString());

			//Criar uma lista de pedidos e adicioná-lo a lista de pedidos  
			ListaPedidos lpedidos = new ListaPedidos();

			Pedido p1 = new Pedido(01, new Date(), c1);
			Pedido p2 = new Pedido(02, new Date(), c2);

			lpedidos.add(p1);
            lpedidos.add(p2);

			//Criar um novo item e adicioná-lo a lista de itens do pedido
			ItemPedido item1 = new ItemPedido("Cadeira", 2, 100.00 );
            ItemPedido item2 = new ItemPedido("Mesa", 1, 200.00);
			ItemPedido item3 = new ItemPedido("Jarro", 3, 10);


			p1.AdicionarItensDoPedido(item1);
			p1.AdicionarItensDoPedido(item2);
			p2.AdicionarItensDoPedido(item3);


            System.out.println(p1.toString());
			System.out.println(lpedidos.toString());

			//Pesquisar um cliente pelo nome e exibir os dados do mesmo.
            Cliente cpesquisado = lciente.pesquisar("João");
            System.out.println("Cliente pesquisado = " + cpesquisado.toString() +"\n");

			//Pesquisar um item do pedido e exebir os dados do mesmo
			System.out.println("Item pesquisado = " + p1.pesquisarItemDoPedido("Cadeira"));
            
	
	}
}

