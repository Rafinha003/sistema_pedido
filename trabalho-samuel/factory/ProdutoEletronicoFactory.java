package factory;

import model.Produto;
import model.ProdutoEletronico;

public class ProdutoEletronicoFactory extends ProdutoFactory {
    public Produto criarProduto(String nome, double preco) {
        return new ProdutoEletronico(nome, preco);
    }
}
