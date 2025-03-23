package service;

import Exceptions.InvalidCpfException;
import Exceptions.InvalidEmailException;
import Exceptions.InvalidNomeException;
import Exceptions.InvalidTelefoneException;
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

        String nome = "";
        while (true) {
            try {
                System.out.println("Digite o seu nome:");
                nome = sc.nextLine();
                if (nome.length() < 10) {
                    throw new InvalidNomeException("O nome deve possuir no mínimo 10 caracteres");
                }
                break;
            } catch (InvalidNomeException e) {
                System.out.println(e.getMessage());
            }
        }

        String cpf = "";
        while (true) {
            try {
                System.out.println("Digite o seu CPF:");
                cpf = sc.nextLine();
                if (!cpf.matches("\\d{11}")) {
                    throw new InvalidCpfException("O CPF deve ter 11 dígitos");
                }
                break;
            }catch (InvalidCpfException e){
                System.out.println(e.getMessage());
            }
        }

        String email = "";
        while (true) {
            try {
                System.out.println("Digite o email:");
                email = sc.nextLine();
                if (!email.contains("@")) {
                    throw new InvalidEmailException("O email deve conter '@'");
                }
                break;
            }catch (InvalidEmailException e){
                System.out.println(e.getMessage());
            }
        }

        String telefone = "";
        while (true) {
            try {
            System.out.println("Digite o seu telefone:");
            telefone = sc.nextLine();
            if (telefone.length() < 8) {
                throw new InvalidTelefoneException("O telefone deve conter no mínimo 8 dígitos");
            }
            break;
        } catch (InvalidTelefoneException e){
                System.out.println(e.getMessage());}
        }

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

