package test;

import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cliente cliente1 = new Cliente("João","123456789-10","joao@Gmail.com","(12) 91234-5678");
        Produto produto1 = new Produto(123456,"Arroz",30,2);
        Produto produto2 = new Produto(456781,"Feijão",10,3);

        ItemPedido itemPedido1 = new ItemPedido(produto1,1);
        ItemPedido itemPedido2 = new ItemPedido(produto2,1);

        List<ItemPedido> itens = new ArrayList<>();
        itens.add(itemPedido1);
        itens.add(itemPedido2);


        System.out.println("Olá ");
        Pedido pedido = new Pedido(cliente1, itens, 0);

        System.out.println(pedido.resumoCompra());
    }
}
