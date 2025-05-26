package singleton;

import model.Produto;
import model.Pedido;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    private static BancoDeDados instancia;
    private List<Produto> produtos;
    private List<Pedido> pedidos;

    private BancoDeDados() {
        produtos = new ArrayList<>();
        pedidos = new ArrayList<>();
    }

    public static BancoDeDados getInstancia() {
        if (instancia == null) {
            instancia = new BancoDeDados();
        }
        return instancia;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
