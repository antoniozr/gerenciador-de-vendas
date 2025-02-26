package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();


    public Pedido(Cliente cliente, List<ItemPedido> itens) {
        this.cliente = cliente;
        this.itens = itens;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public double resumoCompra() {
        double total = 0;
        System.out.println("Cliente: " + this.cliente.getNome());
        for (ItemPedido itemPedido : itens) {
            total += itemPedido.calcularSubTotal();
            System.out.println("Produto: " + itemPedido.getProduto().getNome() +
                    " - Qtd: " + itemPedido.getProduto().getQuantidade() +
                    " Subtotal: " + itemPedido.calcularSubTotal());
        }
        System.out.println("Valor total: " + total);
        return total;
    }

}
