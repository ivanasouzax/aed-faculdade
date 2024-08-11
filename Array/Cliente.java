import java.util.Date;

public class Cliente extends Pessoa {
    private Date dataultimacompra; 
    private Date dtdecadastro;
	
	
	public Cliente(String nome, String endereco, String telefone, Date datadenascimento, Date dataultimacompra, Date dtdecadastro) {
		super(nome, endereco, telefone, datadenascimento);
		this.setDataultimacompra(dataultimacompra); 
		this.setDtdecadastro(dtdecadastro); 
	}


	public Date getDataultimacompra() {
		return dataultimacompra;
	}


	public void setDataultimacompra(Date dataultimacompra) {
		this.dataultimacompra = dataultimacompra;
	}


	public Date getDtdecadastro() {
		return dtdecadastro;
	}


	public void setDtdecadastro(Date dtdecadastro) {
		this.dtdecadastro = dtdecadastro;
	} 
	
	@Override
	public String toString() {
		return  "Cliente: " + this.getNome() + " " +
				"Ultima compra: " + this.dataultimacompra; 

  }
}
