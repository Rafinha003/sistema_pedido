import facade.SistemaDePedidosFacade;
import model.Produto;
import model.Pedido;

public class Main {
    public static void main(String[] args) {
        SistemaDePedidosFacade sistema = new SistemaDePedidosFacade();

        Produto p1 = sistema.criarProduto("eletronico", "Fone de Ouvido", 150.00);
        Produto p2 = sistema.criarProduto("alimenticio", "Pizza Congelada", 25.90);

        Pedido pedido = sistema.criarPedido();
        sistema.adicionarProdutoAoPedido(pedido, p1);
        sistema.adicionarProdutoAoPedido(pedido, p2);

        double total = sistema.calcularTotalPedido(pedido);
        System.out.println("Total do pedido: R$" + total);

        sistema.finalizarPedido(pedido);
        System.out.println("Pedido finalizado com " + pedido.getItens().size() + " itens.");
    }
}
