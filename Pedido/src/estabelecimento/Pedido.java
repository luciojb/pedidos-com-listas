package estabelecimento;

import java.util.List;
import java.util.ArrayList;

public class Pedido extends Operacao{
	private int codigo;
	private Vendedor vendedor;
	private Pessoa cliente;
	private List<Produto> listaProdutos;
	
	public Pedido() {
		super();
		vendedor = new Vendedor();
		cliente = new Pessoa();
		listaProdutos = new ArrayList<>();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if (codigo>0)
			this.codigo = codigo;
	}
	
	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		if (! listaProdutos.isEmpty()) 
			this.listaProdutos = listaProdutos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido [codigo=");
		builder.append(codigo);
		builder.append(", vendedor=");
		builder.append(vendedor.toString());
		builder.append(", cliente=");
		builder.append(cliente.toString());
		builder.append(", \nlistaProdutos= [\n");
		for (Produto p : listaProdutos){
			builder.append(p.toString()+"\n");
		}
		builder.append("]]\n");
		return builder.toString();
	}
	
	
	
	
	
}
