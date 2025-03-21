package service;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteService {
    List<Cliente> clientes = new ArrayList<>();
    Scanner sc;

    public ClienteService(Scanner sc) {
        this.sc = sc;
    }

    public void cadastrarCliente() {


        System.out.println("Digite o seu nome:");
        String nome = sc.nextLine();

        System.out.println("Digite o seu CPF:");
        String cpf = sc.nextLine();

        System.out.println("Digite o email:");
        String email = sc.nextLine();

        System.out.println("Digite o seu telefone:");
        String telefone = sc.nextLine();

        Cliente cliente = new Cliente(nome, cpf, email, telefone);

        clientes.add(cliente);
        System.out.println("Cliente cadastrado!");

    }

    public List<Cliente> listarClientes() {
        if (clientes.isEmpty()) {
            System.out.printf("Nenhum cliente cadastrado!\n");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente.toString());
            }
            System.out.println("********************************");
        }
        return clientes;
    }

    public Cliente buscarCliente() {


        System.out.println("Para encontrar um cliente digite o seu CPF:");
        String cpf = sc.nextLine();

        Cliente clienteSelecionado = null;

        for (Cliente cliente : clientes) {
            if (cpf.equals(cliente.getCpf())) {
                clienteSelecionado = cliente;
                break;
            }
        }

        if (clienteSelecionado == null) {
            System.out.println("Cliente não encontrado!");
            return null;
        } else {
            System.out.println("Nome: " + clienteSelecionado.getNome() +
                    " |CPF: " + clienteSelecionado.getCpf() +
                    " |email: " + clienteSelecionado.getEmail() +
                    " |telefone: " + clienteSelecionado.getTelefone());
            return clienteSelecionado;

        }

    }

}

