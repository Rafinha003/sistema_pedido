package factory;

import model.Produto;
import model.ProdutoAlimenticio;

public class ProdutoAlimenticioFactory extends ProdutoFactory {
    public Produto criarProduto(String nome, double preco) {
        return new ProdutoAlimenticio(nome, preco);
    }
}
