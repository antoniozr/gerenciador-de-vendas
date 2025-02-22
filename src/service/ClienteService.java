package service;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteService {
    List<Cliente> clientes = new ArrayList<>();

    public void cadastrarCliente(){
        Scanner sc = new Scanner(System.in);

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

}
