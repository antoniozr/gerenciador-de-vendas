package service;

import model.ItemPedido;
import model.Pedido;
import model.Produto;

import java.util.List;
import java.util.Scanner;

public class ItemPedidoService {
    Scanner sc = new Scanner(System.in);

    public ItemPedido criarItemPedido(List<Produto> produtos) {
        System.out.println("Produtos disponiveis:");
        for (Produto produto: produtos){
            System.out.println("ID: " + produto.getId() + " | Nome: " + produto.getNome() +
                    " | Preço " + produto.getPreco() + " | Quantidade:" + produto.getQuantidade());
        }
        System.out.println("Digite o ID do produto: ");
        int idProduto = sc.nextInt();

        Produto produtoSelecionado = null;

        for (Produto produto: produtos){
            if (produto.getId() == idProduto){
                produtoSelecionado = produto;
                break;
            }
        }

        if (produtoSelecionado == null){
            System.out.println("Produto não encontrado!");
            return null;
        }

        System.out.println("Digite a quantidade desejada: ");
        int quantidade = sc.nextInt();

        if (quantidade <= produtoSelecionado.getQuantidade()) {
            produtoSelecionado.setQuantidade(produtoSelecionado.getQuantidade() - quantidade);
            ItemPedido itemPedido = new ItemPedido(produtoSelecionado, quantidade);
            System.out.println("Item adicionado com sucesso!");
            return itemPedido;
        }else {
            System.out.println("Estoque insuficiente");
            return null;
        }

    }

}

