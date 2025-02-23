package test;

import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import service.ClienteService;
import service.ItemPedidoService;
import service.ProdutoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test02 {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        ProdutoService produtoService = new ProdutoService();
        ItemPedidoService itemPedidoService = new ItemPedidoService();

        Scanner sc = new Scanner(System.in);

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("*******MENU***********");
            System.out.println("1 - Cadastrar o Cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Buscar cliente pelo CPF");
            System.out.println("4 - Cadastrar produto");
            System.out.println("5 - Adicionar item ao pedido");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("*** Cadastrar Cliente ***");
                    clienteService.cadastrarCliente();
                    break;
                case 2:
                    System.out.println("*** Listando Clientes ***");
                    clienteService.listarClientes();
                    break;
                case 3:
                    System.out.println("*** Buscando clientes por CPF ***");
                    clienteService.buscarClientes();
                    break;
                case 4:
                    System.out.println("*** Cadastrar Produto ***");
                    produtoService.cadastrarProduto();
                    break;
                case 5:
                    System.out.println("*** Adicionar item ao pedido ***");
                    ItemPedido itemPedido = itemPedidoService.criarItemPedido(produtoService.listarProdutos());
                    break;
            }
        }


        System.out.println();
    }
}
