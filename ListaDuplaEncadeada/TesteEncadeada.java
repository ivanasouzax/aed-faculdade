import java.util.Date;

public class TesteEncadeada{

		public static void main (String[] args) {
			
			//Criar um novo cliente e adicioná-lo à lista de clientes.
			Cliente c1 = new Cliente("João", "Rua cruzeiro" , "77 8888-4444", new Date(), new Date(), new Date());
			Cliente c2 = new Cliente("Ivana", "Rua primavera" , "77 8888-4444", new Date(), new Date(), new Date());
			
			ListaEncadeadaCliente lciente = new ListaEncadeadaCliente();

			lciente.add(c1);
			lciente.add(c2);
			
			System.out.println(lciente.toString());

			 // Removendo um cliente
			 Cliente removido = lciente.remover("João");
			 if (removido != null) {
				 System.out.println("\nCliente removido: " + removido.getNome());
			 } else {
				 System.out.println("\nCliente não encontrado para remoção.");
			 }
	 
			 // Exibindo a lista de clientes após remoção
			 System.out.println("\nLista de clientes após remoção:");
			 System.out.println(lciente);

			 // Inserindo cliente antes de outro
			 Cliente c3 = new Cliente("Amanda", "Rua candeias", "77 9999-4444", new Date(), new Date(), new Date());
			 lciente.inserirAntes("Ivana", c3);

			 System.out.println(lciente);

			 //Teste pedidos

			 Pedido p1 = new Pedido(111, new Date(), c1);
			 Pedido p2 = new Pedido(222, new Date(), c2);

			 ListaEncadeadaPedidos lpedidos = new ListaEncadeadaPedidos();

			 lpedidos.add(p1);
			 lpedidos.add(p2);

			 System.out.println(lpedidos.pesquisar(111));

	}
}

