package factory;

import model.Produto;

public abstract class ProdutoFactory {
    public abstract Produto criarProduto(String nome, double preco);
}
