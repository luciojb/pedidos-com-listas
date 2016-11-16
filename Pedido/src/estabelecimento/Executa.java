package estabelecimento;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

public class Executa {

	public static void main(String[] args) {
		
		//Cria-se uma nova lista de produtos, que servirá para armazenar produtos em determinadas circunstâncias.
		List<Produto> listaProdutos = new ArrayList<>();
		
		//Cria-se uma lista de pedidos, para armazenar pedidos que serão passados para classe ListaPedidos no método setLista().
		//Além de servir para armazenar em outras ocasiões.
		List<Pedido> pedidos = new ArrayList<>();
		
		//Crio um novo pedido.
		Pedido pedido = new Pedido();
		//Vejo no meu relógio que horas estou começando a anotar o pedido.
		pedido.setDtInicio(new Date());
		//Digo que código eu quero para meu pedido. Se precisasse, poderia fazer validação pegando todos os códigos que já tenho na lista de pedidos.
		pedido.setCodigo(1);
		
		//Anoto meu primeiro produto e suas características, como seu código na minha loja (rico hein), descrição e etc. 
		//Além de quantos produtos meu cliente quer.
		Produto prod = new Produto();
		
		prod.setCodigo(1);
		prod.setDescricao("Balde");
		prod.setQuantidade(10);
		prod.setValor(2.50);
		
		//Adiciono ele na minha lista de produtos
		listaProdutos.add(prod);
		
		
		//Agora quero mais um produto. Como o primeiro produto já salvei na lista e ele está anotado, anoto um novo.
		prod = new Produto();
		prod.setCodigo(3);
		prod.setDescricao("Maçã");
		prod.setQuantidade(1);
		prod.setValor(1.90);
		//total de R$251,90...
		
		//Adiciono ele na minha lista.
		listaProdutos.add(prod);
		
		
		//Agora, meu cliente não quer mais nada. Então, finalizo e adiciono a lista de produtos ao pedido.
		//Além das informações do meu cliente e minhas informações (meu código é 1 e me chamo Ciclano).
		pedido.setListaProdutos(listaProdutos);
		
		pedido.getCliente().setCodigo(1);
		pedido.getCliente().setNome("Fulano");
		pedido.getCliente().setEmail("123@456.689.10");
		
		pedido.getVendedor().setCodigo(1);
		pedido.getVendedor().setNome("Ciclano");
		
		//Terminei. Anotando a hora....
		pedido.setDtFim(new Date());
		
		
		//Agora, adiciono o pedido que acabei de fazer à minha lista de pedidos.
		pedidos.add(pedido);
		
//==================================================================== Novo Pedido
		pedido = new Pedido();
	
		//Como tenho um pedido novo, não tenho nada nele. Então tenho que fazer uma NOVA lista de produtos
		listaProdutos = new ArrayList<>();
		
		//Repetido.....
		pedido.setDtInicio(new Date());
		pedido.setCodigo(2);
		
		prod = new Produto();
		
		prod.setCodigo(2);
		prod.setDescricao("Pendrive 4MB");
		prod.setQuantidade(12);
		prod.setValor(29.65);
		
		listaProdutos.add(prod);
		
		prod = new Produto();
		
		prod.setCodigo(8);
		prod.setDescricao("Vassoura");
		prod.setQuantidade(4);
		prod.setValor(16.90);
		//total de R$423,40
		
		listaProdutos.add(prod);
		
		pedido.setListaProdutos(listaProdutos);
		
		pedido.getCliente().setCodigo(2);
		pedido.getCliente().setNome("Beltrano");
		pedido.getCliente().setEmail("abc@def.ghi.jk");
		
		pedido.getVendedor().setCodigo(5);
		pedido.getVendedor().setNome("Amano");
		
		pedido.setDtFim(new Date());
		
		pedidos.add(pedido);
		
		//Pronto. Já trabalhei que chega. Quero Descançar. Vou imprimir minha lista de pedidos....
		
//================================================================== Novo objeto ListaPedidos
		
		/*
		 * Lista é objeto
		 * Lista contém listaPedidos
		 * listaPedidos contém pedidos
		 * pedidos contém listaProdutos
		 * listaProdutos contém produtos
		 * produtos contém id
		 */
		
		
		ListaPedidos lista = new ListaPedidos();
		
		//Seto minha lista de pedidos do objeto
		lista.setLista(pedidos);
		
		/*
		 * Agora faço uma nova lista de pedidos e digo que ela recebe a lista de pedidos do objeto lista,
		 * Mas somente pedidos que tenham em sua lista de produtos
		 * Um determinado produto que estou passando como parâmetro.
		 * obs.: (lista=objeto).(lista de pedidos do objeto).(index 1 = 2º pedido da lista).(lista de produtos do 2º pedido).(1º produto da lista de produtos)
		 */
		List<Pedido> listaPedidos = lista.pedidosComProdutoId(lista.getLista().get(1).getListaProdutos().get(0));
		System.out.println("Pedidos que contenham o produto "+lista.getLista().get(1).getListaProdutos().get(0).getDescricao()+":");//Só pego a descrição do primeiro produto
		
		
		//Aqui, para cada pedido que se encontra na lista dos pedidos com o produto que passei como parâmetro,
		//Eu mostro as informações do pedido.
		for (Pedido ped : listaPedidos){
			System.out.println(ped.toString());
			
		}
		//--Terminei de mostrar as informações do 1º exercício. No meu note deu certo.
		
		
		//Agora, dou um new no meu pedido que já instanciei na linha 20,
		//E digo a ele que ele recebe o pedido que contenha o maior valor em mercadoria,
		//Método do objeto lista.
		
		pedido = lista.PedidoMaiorValor();
		
		//Aqui só mostro o toString() do meu pedido. Peço revisar na minha classe, fiz umas alterações no toString() da classe Pedido.
		System.out.print("O pedido que possui o maior valor é: \n"+pedido.toString()+",\ncom um total de R$");
		
		//A única finalidade é mostrar o total do pedido. Pego a lista de produtos -->pedido.getListaProdutos()<--
		//E digo que para cada produto que há na lista ele me calcule o total (valor do produto * sua quantidade),
		//Somando (+=) com o que já tenho dos outros produtos.
		double total =0;
		for (Produto p : pedido.getListaProdutos()){
			total+=p.getValor()*p.getQuantidade();
		}
		System.out.println(total+"\n\n");
		
		//faço um novo calendário...
		Calendar cal = Calendar.getInstance();
		
		
		//Aqui, temos uma maneira rápida de setar a data: se vc der cal.set, ele vai sugerir muitas coisas. Entre elas ***cal.set(YEAR, MONTH, DAY)***
		//Só colocar os valores. Quando vc seta o mês, deve colocar um número a menos, pois o índice inicia com 0 (zero). EX.: dezembro = 11.
		cal.set(2016, 9, 30); // obs: mês começa com índice 0=janeiro. 1=fevereiro......
		
		//Outro truque. Quando setei somente Calendar.hour, me retornou um dia a mais. Não sei pq. Tive que colocar HOUR_OF_DAY...
		cal.set(Calendar.HOUR_OF_DAY, 12);
		
		//Pego a data do calendário no formato Date, que quero passar como parâmetro no 3º exercício.
		Date dataInicioPeriodo = cal.getTime();
		
		//E pego minha data atual.
		Date dataFimPeriodo = new Date();
		
		
		//Terei então uma lista de pedidos em que o vendedor do meu 2º pedido da lista de pedidos está presente.
		listaPedidos = lista.pedidosVendedorPorPeriodo(lista.getLista().get(1).getVendedor(), dataInicioPeriodo, dataFimPeriodo);
		
		//Aqui pego nome do vendedor.
		System.out.println("Do período de "+dataInicioPeriodo+"\naté "+dataFimPeriodo+"\ntemos os seguintes pedidos pelo vendedor "+lista.getLista().get(1).getVendedor().getNome()+": \n");
		
		
		//Digo que para cada pedido na lista de pedidos em que meu vendedor aparece, mostro suas informações.
		for (Pedido ped : listaPedidos){
			System.out.println(ped.toString());
		}
		
		
		//Por último, preciso de uma lista de 2 clientes que mais compraram dos dias a tal. 
		List<Pessoa> listaMaioresClientes = lista.clientesMaioresPorPeriodo(dataInicioPeriodo, dataFimPeriodo, 2);
		
		
		System.out.println("Temos as seguintes informações dos 2 maiores clientes no período informado: ");
		
		//E então.... Tcharammmm para cada cliente dessa lista, mostro que seu índex+1 (pq começa com zero...) cliente é... e mostro suas informações.
		for (Pessoa c : listaMaioresClientes){
			System.out.println((listaMaioresClientes.indexOf(c)+1)+"º cliente = "+ c.toString());
		}
		
		//Fim! Espero ter gostado do sistema super avançado de pedidos para maçãs e pendrives de 4MB! 
		
		//Já pensou em possuir um pendrive de tanta capacidade nos anos 80???
		
		
		
	}

}
