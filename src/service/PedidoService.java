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
        if (cliente == null){
            System.out.println("Não é possilvel criar um pedido sem um cliente");
            return;
        }

        List<ItemPedido> itens = new ArrayList<>();

        String resposta = "s";
        while (resposta.equals("s")) {
            System.out.println("Selecione o produto!");
            ItemPedido item = itemPedidoService.criarItemPedido(produtoService);

            if (item != null) {
                itens.add(item);
            }

            System.out.println("Produtos adicionados até agora:");
            for (ItemPedido itemPedido: itens){
                System.out.println("ID: " + itemPedido.getProduto().getId() + " | Nome: " + itemPedido.getProduto().getNome() + " | Quantidade: "
                        + itemPedido.getQuantidade());
            }
            System.out.println("Adicionar outro produto? (s/n)");
            resposta = sc.nextLine().toLowerCase();
        }

        // Calcula o valor tatal do pedido
        double totalPedido = 0;
        for (ItemPedido itemPedido: itens){
            totalPedido += (itemPedido.getProduto().getPreco()) * itemPedido.getQuantidade();
        }
        System.out.println("Valor total do pedido: " + totalPedido);

        // Cria o pedido
        Pedido pedido = new Pedido(cliente, itens, totalPedido);
        pedidos.add(pedido);
        System.out.println("Pedido criado com sucesso!");
    }

}
