import java.util.Date;

public class Pedido {
	private int codigoPedido;
	private Date datadoPedido; 
	private Cliente clientedoPedido;
	private ListaItensDoPedido listaItensDoPedidos;
	
	public Pedido(int codigoPedido, Date datadoPedido, Cliente clientedoPedido) {
		this.setCodigoPedido(codigoPedido);
		this.setDatadoPedido(datadoPedido);
		this.setClientedoPedido(clientedoPedido);
		this.listaItensDoPedidos = new ListaItensDoPedido();
	}
	public int getCodigoPedido() {
		return codigoPedido;
	}
	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	public Date getDatadoPedido() {
		return datadoPedido;
	}
	public void setDatadoPedido(Date datadoPedido) {
		this.datadoPedido = datadoPedido;
	}
	public Cliente getClientedoPedido() {
		return clientedoPedido;
	}
	public void setClientedoPedido(Cliente clientedoPedido) {
		this.clientedoPedido = clientedoPedido;
	}

	public void AdicionarItensDoPedido(ItemPedido itensDoPedido) {
		this.listaItensDoPedidos.add(itensDoPedido);
	}

	public void removerItemDoPedido(String nomeDoProduto) {
		listaItensDoPedidos.remover(nomeDoProduto);
	}

	public ItemPedido pesquisarItemDoPedido(String nomeDoProduto) {
		return listaItensDoPedidos.pesquisarItemPedido(nomeDoProduto);
	}

	public String ExibirItensDoPedido(){
		StringBuilder sb = new StringBuilder();
		for (ItemPedido item : listaItensDoPedidos.getListaItensDoPedido()) {
			sb.append(item.toString()).append("\n");
		}
		return sb.toString();
	}

	@Override
    public String toString() {
        return "Pedido: codigo do pedido = " + codigoPedido + "\n" +
		 " Data do pedido = " + datadoPedido + "\n" +
		 " Cliente do pedido = " + clientedoPedido.getNome() + "\n" +
		 " Lista Itens do pedido = " + ExibirItensDoPedido() + "\n" +
		 " Valor total do pedido = " + listaItensDoPedidos.valortotalPedido() + "\n";
    }

}
