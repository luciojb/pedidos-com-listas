package estabelecimento;

public class Cliente {
	private int codigo;
	private String nome, email;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		if (codigo>0)
			this.codigo = codigo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if (email.length()>0)
			this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if (nome.length()>0)
			this.nome = nome;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [codigo=");
		builder.append(codigo);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
}
