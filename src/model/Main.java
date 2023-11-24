package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaConsultaMedica sistema = new SistemaConsultaMedica();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Incluir Paciente");
            System.out.println("2. Alterar Paciente");
            System.out.println("3. Realizar Consulta");
            System.out.println("4. Listar Pacientes");
            System.out.println("5. Mostrar Paciente");
            System.out.println("6. Apagar Paciente");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o nome do paciente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a data de nascimento (dd/MM/yyyy): ");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String dataString = scanner.nextLine();

                    try {
                        LocalDate dataNascimento = LocalDate.parse(dataString, formatter);
                        Paciente novoPaciente = new Paciente(nome, dataNascimento);
                        sistema.incluirPaciente(novoPaciente);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
                    }
                    break;
                case 2:
                    System.out.print("Digite o nome do paciente a ser alterado: ");
                    String nomeAlterar = scanner.nextLine();
                    System.out.print("Digite o novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Digite a nova data de nascimento (dd/MM/yyyy): ");
                    String novaDataString = scanner.nextLine();

                    try {
                        LocalDate novaDataNascimento = LocalDate.parse(novaDataString);
                        sistema.alterarPaciente(nomeAlterar, novoNome, novaDataNascimento);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o nome do paciente para realizar a consulta: ");
                    String nomeConsulta = scanner.nextLine();
                    System.out.print("Digite a data da consulta (dd/MM/yyyy): ");
                    String dataConsultaString = scanner.nextLine();

                    try {
                        LocalDate dataConsulta = LocalDate.parse(dataConsultaString);
                        System.out.print("Digite a descrição da consulta: ");
                        String descricaoConsulta = scanner.nextLine();
                        Atendimento novaConsulta = new Atendimento(dataConsulta, descricaoConsulta);
                        sistema.realizarConsulta(nomeConsulta, novaConsulta);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
                    }
                    break;
                case 4:
                    sistema.listarPacientes();
                    break;
                case 5:
                    System.out.print("Digite o nome do paciente a ser mostrado: ");
                    String nomeMostrar = scanner.nextLine();
                    sistema.mostrarPaciente(nomeMostrar);
                    break;
                case 6:
                    System.out.print("Digite o nome do paciente a ser apagado: ");
                    String nomeApagar = scanner.nextLine();
                    sistema.apagarPaciente(nomeApagar);
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até logo!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
