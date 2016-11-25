package estabelecimento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaPedidos {
	private List<Pedido>  lista;

	public ListaPedidos() {
		super();
		lista = new ArrayList<>();
	}

	public List<Pedido> getLista() {
		return lista;
	}

	public void setLista(List<Pedido> lista) {
		if (! lista.isEmpty())
			this.lista = lista;
	}
	
	public List<Pedido> pedidosComProdutoId (Produto produtoPesquisa){
		
		List<Pedido> listaPedidos = new ArrayList<>();
		
		
		for (Pedido p: getLista()){
			for (Produto prod : p.getListaProdutos()){
				if (produtoPesquisa.getCodigo()==prod.getCodigo()){
					listaPedidos.add(p);
					break;
				}
			}
		}
		
		return listaPedidos;
	}
	
	public Pedido PedidoMaiorValor(){
		Pedido p = new Pedido();
		double maiorSoma=0;
		for (Pedido ped: getLista()){
			double soma=0;
			for (Produto prod : ped.getListaProdutos()){
				soma += prod.getValor()*prod.getQuantidade();
			}
			if (ped == getLista().get(0)){
				maiorSoma=soma;
				p=ped;
			} else if (soma>maiorSoma){
				maiorSoma=soma;
				p=ped;
			}
		}
		
		
		return p;
	}
	
	public List<Pedido> pedidosVendedorPorPeriodo (Vendedor vendedor, Date inicio, Date fim){
		List<Pedido> pedidosPorVendedor = new ArrayList<>();
		
		for (Pedido ped: getLista()){
			if (ped.getVendedor().getCodigo() == vendedor.getCodigo() && 
					ped.getDtInicio().getTime()>=inicio.getTime() && 
					ped.getDtFim().getTime()<=fim.getTime()){
				pedidosPorVendedor.add(ped);
			}
		
		}
		
		
		return pedidosPorVendedor;
	}
	
	public List<Pessoa> clientesMaioresPorPeriodo (Date inicio, Date fim, int nMaiores){
		List<Pessoa> maioresClientes = new ArrayList<>();
		List<Double> maioresSomas = new ArrayList<>();
		
		
			for (Pedido ped: getLista()){
				double soma=0;
				Pessoa c = ped.getCliente();
				int menorSomaIndice=0;
				double menorSoma=0;
				boolean mesmoCliente = false;
				for (Produto prod : ped.getListaProdutos()){
					soma += prod.getValor()*prod.getQuantidade();
				}
				
				if (ped.getDtInicio().getTime()>=inicio.getTime() && ped.getDtFim().getTime()<=fim.getTime()){
					
					if (maioresSomas.size()<=nMaiores){
						for(Pessoa cli : maioresClientes){
							if (c.getCodigo()==cli.getCodigo()){
								mesmoCliente = true;
								soma+=maioresSomas.get(maioresClientes.indexOf(cli));
								maioresSomas.set(maioresClientes.indexOf(cli), soma);
								break;
							}
						}
						if (! mesmoCliente){
							maioresSomas.add(soma);
							maioresClientes.add(c);
						}
					} else {
						
						for(Pessoa cli : maioresClientes){
							if (c.getCodigo()==cli.getCodigo()){
								mesmoCliente = true;
								soma+=maioresSomas.get(maioresClientes.indexOf(cli));
								maioresSomas.set(maioresClientes.indexOf(cli), soma);
								break;
							}
						}
						if (! mesmoCliente){
							
							menorSomaIndice=0;
							menorSoma=maioresSomas.get(menorSomaIndice);
							
							for (double sum: maioresSomas){
								if (menorSoma<sum){
									menorSoma=sum;
									menorSomaIndice=maioresSomas.indexOf(sum);
								}
							}
							
							if (soma>menorSoma && !maioresClientes.contains(c)){
								maioresSomas.set(menorSomaIndice, soma);
								maioresClientes.set(menorSomaIndice, c);
							}
						}
					}
				}
			}
		
		return maioresClientes;
		
	}
	
	
	
	
}





