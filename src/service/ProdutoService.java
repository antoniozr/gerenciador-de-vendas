package service;

import model.Cliente;
import model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdutoService {
    List<Produto> produtos = new ArrayList<>();
    Scanner sc;

    public ProdutoService(Scanner sc) {
        this.sc = sc;
    }

    public void cadastrarProduto(){

        System.out.println("Digite o ID do produto:");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite o nome do produto:");
        String nome = sc.nextLine();

        System.out.println("Digite o preço do produto:");
        double preco = sc.nextDouble();

        System.out.println("Digite quantidade em estoque:");
        int quantidade = sc.nextInt();

        Produto produto = new Produto(id, nome, preco, quantidade);

        produtos.add(produto);

        System.out.println("Produto cadastrado com sucesso!");

    }

    public List<Produto> listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.printf("Nenhum cliente cadastrado!\n");
        } else {
            for (Produto produto : produtos) {
                System.out.println("ID: " + produto.getId() +
                        "| Nome: " + produto.getNome() +
                        "| Preço: " + produto.getPreco() +
                        "| Quantidade: " + produto.getQuantidade());
            }
            System.out.println("********************************");
        }
        return produtos;
    }

}
