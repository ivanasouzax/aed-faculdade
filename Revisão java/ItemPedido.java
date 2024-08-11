
//Os itens do pedido são representados pela classe ItemPedido que possui os atributos: nomeDoProduto, quantidade, valorunitario, subtotal. 

public class ItemPedido {
	private String nomeDoProduto; 
	private int quantidade; 
	private double valorunitario; 
	private double subtotal; 
	
	public ItemPedido(String nomeDoProduto, int quantidade, double valorunitario) {
		
		this.nomeDoProduto = nomeDoProduto;
		this.quantidade = quantidade;
		this.valorunitario = valorunitario;
		this.subtotal = quantidade * valorunitario;
	}

	public String getNomeDoProduto() {
		return nomeDoProduto;
	}

	public void setNomeDoProduto(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
		this.subtotal = quantidade * valorunitario;
	}

	public double getValorunitario() {
		return valorunitario;
	}

	public void setValorunitario(double valorunitario) {
		this.valorunitario = valorunitario;
		this.subtotal = quantidade * valorunitario;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "Item Pedido: nome do Produto = " + nomeDoProduto + ", quantidade = " + quantidade + ", valor unitario = "
				+ valorunitario + ", subtotal = " + subtotal;
	}
}
