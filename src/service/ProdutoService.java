package service;

import model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdutoService {
    List<Produto> produtos = new ArrayList<>();

    public void cadastrarProduto(){
        Scanner sc = new Scanner(System.in);

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
        return produtos;
    }

}
