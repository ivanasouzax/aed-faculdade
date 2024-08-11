import java.util.Date; 

// Uma classe abstrata na qual não pode se dá new. 

public abstract class Pessoa {
	private String nome; 
	private String endereco; 
	private String telefone; 
	private Date datadenascimento; 

	public Pessoa(String nome, String endereco, String telefone, Date datadenascimento) {
		this.nome = nome; 
		this.endereco = endereco; 
		this.telefone = telefone; 
		this.datadenascimento = datadenascimento; 
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDatadenascimento() {
		return datadenascimento;
	}

	public void setDatadenascimento(Date datadenascimento) {
		this.datadenascimento = datadenascimento;
	}	

}

