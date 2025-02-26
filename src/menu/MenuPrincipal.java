package menu;

import service.ClienteService;
import service.ProdutoService;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClienteService clienteService = new ClienteService(sc);
        ProdutoService produtoService = new ProdutoService(sc);

        MenuCliente menuCliente = new MenuCliente(clienteService, sc);
        MenuPedido menuPedido = new MenuPedido(clienteService, produtoService, sc);
        MenuProduto menuProduto = new MenuProduto(produtoService, sc);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("*******MENU***********");
            System.out.println("1 - MENU CLIENTE");
            System.out.println("2 - MENU PRODUTO");
            System.out.println("3 - MENU PEDIDO");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("*** MENU CLIENTE ***");
                    menuCliente.exibirMenu();
                    break;
                case 2:
                    System.out.println("*** MENU PRODUTO ***");
                    menuProduto.exibirMenu();
                    break;
                case 3:
                    System.out.println("*** MENU PEDIDO ***");
                    menuPedido.exibirMenu();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }
}