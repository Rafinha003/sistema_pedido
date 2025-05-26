package model;

import singleton.BancoDeDados;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Produto> itens;
    private boolean finalizado;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.finalizado = false;
    }

    public void adicionarProduto(Produto produto) {
        if (!finalizado) {
            itens.add(produto);
        }
    }

    public double calcularTotal() {
        return itens.stream().mapToDouble(Produto::getPreco).sum();
    }

    public void finalizarPedido() {
        this.finalizado = true;
        BancoDeDados.getInstancia().adicionarPedido(this);
    }

    public List<Produto> getItens() {
        return itens;
    }

    public boolean isFinalizado() {
        return finalizado;
    }
}
