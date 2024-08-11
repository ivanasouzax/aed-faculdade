import java.util.Date;

public class Pedido {
	private int codigoPedido;
	private Date datadoPedido; 
	private Cliente clientedoPedido;
	
	public Pedido(int codigoPedido, Date datadoPedido, Cliente clientedoPedido) {
		this.setCodigoPedido(codigoPedido);
		this.setDatadoPedido(datadoPedido);
		this.setClientedoPedido(clientedoPedido);
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

	@Override
    public String toString() {
        return "Pedido: codigo do pedido = " + codigoPedido + "\n" +
		 " Data do pedido = " + datadoPedido + "\n" +
		 " Cliente do pedido = " + clientedoPedido.getNome() + "\n";
    }

}
