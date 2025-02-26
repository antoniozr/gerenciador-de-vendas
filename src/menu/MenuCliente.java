package menu;

import model.ItemPedido;
import service.ClienteService;

import java.util.Scanner;

public class MenuCliente {
    Scanner sc;
    ClienteService clienteService;

    public MenuCliente(ClienteService clienteService, Scanner sc) {
        this.clienteService = clienteService;
        this.sc = sc;
    }

    public void exibirMenu() {

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("1 - Cadastrar o Cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Buscar cliente pelo CPF");
            System.out.println("0 _ Sair");
            opcao = sc.nextInt();
            sc.nextLine();


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
                    clienteService.buscarCliente();
                    break;
                case 0:
                    System.out.println("Saindo...");

            }
        }

        System.out.println();
    }
}

