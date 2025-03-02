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
            System.out.printf("Nenhum produto cadastrado!\n");
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

    public void atualizarProduto() {
        System.out.println("Esses são os produtos cadastrados!");
        List<Produto> produtos = listarProdutos();
        System.out.println("Selecione um produto digitando o seu ID:");
        int idProduto = sc.nextInt();

        Produto produtoEncontrado = null;
        for (Produto produto: produtos){
            if (idProduto == produto.getId()){
                produtoEncontrado = produto;
                break;
            }
        }

        if (produtoEncontrado != null){
            System.out.println("Produto: " + produtoEncontrado.getNome() +
                    " | Estoque " + produtoEncontrado.getQuantidade() +
                    " | Preço: " + produtoEncontrado.getPreco() );

            System.out.println("Digite o novo preço:");
            double preco = sc.nextDouble();

            System.out.println("Digite a nova quantidade:");
            int quantidade = sc.nextInt();
            sc.nextLine();

            produtoEncontrado.setPreco(preco);
            produtoEncontrado.setQuantidade(quantidade);

            System.out.println("Produto tualizado com sucesso!");

            System.out.println("Estado atual do produto");
            System.out.println("Produto: " + produtoEncontrado.getNome() +
                    " | Estoque " + produtoEncontrado.getQuantidade() +
                    " | Preço: " + produtoEncontrado.getPreco() );
        } else {
            System.out.println("Produto não encontrado!");
        }
    }
}
