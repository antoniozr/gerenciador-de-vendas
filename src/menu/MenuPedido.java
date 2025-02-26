package menu;

import service.ClienteService;
import service.PedidoService;
import service.ProdutoService;

import java.util.Scanner;

public class MenuPedido {
    PedidoService pedidoService ;
    Scanner sc;

    public MenuPedido(ClienteService clienteService, ProdutoService produtoService, Scanner sc) {
        this.pedidoService = new PedidoService(clienteService, produtoService, sc);
        this.sc = sc;
    }

    public void exibirMenu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("1 - CriarPedido");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();


            switch (opcao) {
                case 1:
                    System.out.println("*** CriarPedido ***");
                    pedidoService.criarPedido();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
            }
        }

        System.out.println();
    }
}
