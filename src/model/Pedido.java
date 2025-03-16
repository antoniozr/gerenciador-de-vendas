package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();
    private double total;


    public Pedido(int id , Cliente cliente, List<ItemPedido> itens, double totalPedido) {
        this.id = id;
        this.cliente = cliente;
        this.itens = itens;
        this.total = totalPedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " |Cliente: " + cliente.getNome() +
                " |Itens: " + itens +
                " |Total:" + total;
    }
}