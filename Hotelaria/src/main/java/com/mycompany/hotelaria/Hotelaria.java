package com.mycompany.hotelaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import Dao.HospedeDAO;
import model.Hospede;

public class Hotelaria {

    private static Connection connection;
    private static HospedeDAO hospedeDAO;

    private static void abrirConexao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/hotelaria?user=root&password=12345678");
        }
    }

    private static void fecharConexao() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            abrirConexao();
            hospedeDAO = new HospedeDAO(connection);
            boolean running = true;

            while (running) {
                System.out.println("Escolha uma opção:");
                System.out.println("1. Atualizar Hóspede");
                System.out.println("2. Consultar Hóspede");
                System.out.println("3. Deletar Hóspede");
                System.out.println("4. Inserir Hóspedes");
                System.out.println("5. Sair");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner

                switch (choice) {
                    case 1:
                        System.out.println("Digite o id do hóspede a ser atualizado:");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer do scanner
                        Hospede atualizarHospede = new Hospede(
                                "Pedro",
                                LocalDate.of(1999, 5, 2),
                                "Masculino",
                                "EnderecoTeste2",
                                88888888,
                                987654321,
                                "Pedro@example.com",
                                "Brasil");
                        atualizarHospede.setId(id);

                        hospedeDAO.atualizarHospede(atualizarHospede);
                        System.out.println("Hóspede atualizado com sucesso.");
                        break;

                    case 2:
                        System.out.println("Digite o nome do hóspede a ser consultado:");
                        String nome = scanner.nextLine();
                        Hospede hospedeConsulta = hospedeDAO.consultarHospede(nome);
                        if (hospedeConsulta != null) {
                            System.out.println("Hóspede encontrado: " + hospedeConsulta);
                        } else {
                            System.out.println("Hóspede não encontrado.");
                        }
                        break;

                    case 3:
                        System.out.println("Digite o id do hóspede a ser deletado:");
                        id = scanner.nextInt();
                        hospedeDAO.deletarHospede(id);
                        System.out.println("Hóspede deletado com sucesso.");
                        break;

                    case 4:
                        System.out.println("Você deseja que a operação de inserção seja commitada automaticamente? (true/false):");
                        boolean commit = scanner.nextBoolean();
                        connection.setAutoCommit(commit);

                        long inicio = System.currentTimeMillis();
                        for (int i = 0; i < 10000; i++) {
                            Hospede hospede = new Hospede(
                                    "Joao " + i,
                                    LocalDate.of(1990, 1, 1),
                                    "Masculino",
                                    "EnderecoTeste",
                                    2345678,
                                    123456789,
                                    "Joao" + i + "@example.com",
                                    "Brasil");
                            hospedeDAO.adicionarHospede(hospede);
                        }
                        long fim = System.currentTimeMillis();
                        System.out.println((fim - inicio) + " ms");

                        if (!commit) {
                            connection.commit();
                        }
                        break;

                    case 5:
                        running = false;
                        break;

                    default:
                        System.out.println("Opção inválida, por favor escolha novamente.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fecharConexao();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
