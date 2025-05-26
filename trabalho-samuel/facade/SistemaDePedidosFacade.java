package facade;

import factory.ProdutoFactory;
import factory.ProdutoEletronicoFactory;
import factory.ProdutoAlimenticioFactory;
import model.Pedido;
import model.Produto;
import singleton.BancoDeDados;

public class SistemaDePedidosFacade {

    public Produto criarProduto(String tipo, String nome, double preco) {
        ProdutoFactory factory;
        switch (tipo.toLowerCase()) {
            case "eletronico":
                factory = new ProdutoEletronicoFactory();
                break;
            case "alimenticio":
                factory = new ProdutoAlimenticioFactory();
                break;
            default:
                throw new IllegalArgumentException("Tipo de produto desconhecido");
        }
        Produto produto = factory.criarProduto(nome, preco);
        BancoDeDados.getInstancia().adicionarProduto(produto);
        return produto;
    }

    public Pedido criarPedido() {
        return new Pedido();
    }

    public void adicionarProdutoAoPedido(Pedido pedido, Produto produto) {
        pedido.adicionarProduto(produto);
    }

    public double calcularTotalPedido(Pedido pedido) {
        return pedido.calcularTotal();
    }

    public void finalizarPedido(Pedido pedido) {
        pedido.finalizarPedido();
    }
}
