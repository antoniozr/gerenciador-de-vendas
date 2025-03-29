package service;

import Exceptions.InvalidIdProdutoException;
import Exceptions.InvalidNomeException;
import Exceptions.InvalidPrecoException;
import Exceptions.InvalidQuantidadeException;
import model.Cliente;
import model.Produto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProdutoService {
    List<Produto> produtos = new ArrayList<>();
    Scanner sc;

    public ProdutoService(Scanner sc) {
        this.sc = sc;
    }

    public void cadastrarProduto() {

        int id = 0;
        while (true) {
            try {
                System.out.println("Digite o ID do produto:");
                id = sc.nextInt();
                sc.nextLine();
                if (id <= 0) {
                    throw new InvalidIdProdutoException("O ID deve ser um número positivo");
                }
                for (Produto produto: produtos) {
                    if (produto.getId() == id) {
                        throw new InvalidIdProdutoException("Já existe um produto com este ID");
                    }
                }
                break;
            } catch (InputMismatchException e){
                System.out.println("ID inválido! Digite um número inteiro.");
                sc.nextLine();
            } catch (InvalidIdProdutoException e) {
                System.out.println(e.getMessage());
            }
        }

        String nome = "";
        while (true) {
            try {
                System.out.println("Digite o nome do produto:");
                nome = sc.nextLine();
                if (nome.length() < 3) {
                    throw new InvalidNomeException("O nome deve conter no mínimo 3 caracteres");
                }
                break;
            } catch (InvalidNomeException e) {
                System.out.println(e.getMessage());
            }
        }

        double preco = 0;
        while (true) {
            try {
                System.out.println("Digite o preço do produto:");
                preco = sc.nextDouble();
                sc.nextLine();
                if (preco < 0) {
                    throw new InvalidPrecoException("O preço deve ser maior que zero");
                }
                break;
            } catch (InputMismatchException e){
                System.out.println("Preço inválido! Digite um número");
                sc.nextLine();
            } catch (InvalidPrecoException e) {
                System.out.println(e.getMessage());
            }
        }

        int quantidade = 0;
        while (true) {
            try {
                System.out.println("Digite quantidade em estoque:");
                quantidade = sc.nextInt();
                sc.nextLine();
                if (quantidade < 0) {
                    throw new InvalidQuantidadeException("A quantidade não pode ser negativa");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida! Digite um número inteiro");
                sc.nextLine();
            } catch (InvalidQuantidadeException e){
                System.out.println(e.getMessage());
            }
        }

        Produto produto = new Produto(id, nome, preco, quantidade);

        produtos.add(produto);

        System.out.println("Produto cadastrado com sucesso!");

    }

    public List<Produto> listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.printf("Nenhum produto cadastrado!\n");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto.toString());
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
        for (Produto produto : produtos) {
            if (idProduto == produto.getId()) {
                produtoEncontrado = produto;
                break;
            }
        }

        if (produtoEncontrado != null) {
            System.out.println("Produto: " + produtoEncontrado.getNome() +
                    " | Estoque " + produtoEncontrado.getQuantidade() +
                    " | Preço: " + produtoEncontrado.getPreco());

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
                    " | Preço: " + produtoEncontrado.getPreco());
        } else {
            System.out.println("Produto não encontrado!");
        }
    }
}
