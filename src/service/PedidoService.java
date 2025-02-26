package service;

import model.Cliente;
import model.ItemPedido;
import model.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PedidoService {
    List<Pedido> pedidos = new ArrayList<>();
    ClienteService clienteService;
    ItemPedidoService itemPedidoService;
    ProdutoService produtoService;
    Scanner sc;

    public PedidoService(ClienteService clienteService, ProdutoService produtoService, Scanner sc) {
        this.clienteService = clienteService;
        this.produtoService = produtoService;
        this.itemPedidoService = new ItemPedidoService(produtoService);
        this.sc = sc;
    }

    public void criarPedido() {

        System.out.println("Selecione um cliente!");
        clienteService.listarClientes();

        Cliente cliente = clienteService.buscarCliente();
        while (cliente == null){
            System.out.println("Tente novamente.");
            cliente = clienteService.buscarCliente();
        }
        System.out.println("Cliente encontrado com sucesso!");

        List<ItemPedido> itens = new ArrayList<>();

        System.out.println("Selecione o produto!");

        ItemPedido item = itemPedidoService.criarItemPedido(produtoService);

        if (item != null){
            itens.add(item);
        }
        if (itens.isEmpty()){
            
        }

        Pedido pedido = new Pedido(cliente, itens);
        pedidos.add(pedido);
        System.out.println("Pedido criado com sucesso!");
    }

}
