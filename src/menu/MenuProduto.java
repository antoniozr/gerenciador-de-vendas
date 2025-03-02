package menu;

import model.ItemPedido;
import service.ClienteService;
import service.ItemPedidoService;
import service.ProdutoService;

import java.util.Scanner;

public class MenuProduto {
    ProdutoService produtoService;
    Scanner sc;

    public MenuProduto(ProdutoService produtoService, Scanner sc) {
        this.produtoService = produtoService;
        this.sc = sc;
    }

    public void exibirMenu() {

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Atualizar preço e estoque");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();


            switch (opcao) {
                case 1:
                    System.out.println("*** Cadastrar Produto ***");
                    produtoService.cadastrarProduto();
                    break;
                case 2:
                    System.out.println("*** Listando produtos ***");
                    produtoService.listarProdutos();
                    break;
                case 3:
                    System.out.println("*** Atualizando preço e estoque ***");
                    produtoService.atualizarProduto();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
            }
        }

        System.out.println();
    }
}
