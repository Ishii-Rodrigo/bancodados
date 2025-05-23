package com.clinica.view;

import com.clinica.model.Medico;
import com.clinica.database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cadastro de Médico ===");

        int id = 0;
        try {
            System.out.print("Digite o ID do médico: ");
            id = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Erro: ID inválido. Certifique-se de digitar um número inteiro.");
            return;
        }

        System.out.print("Digite o nome do médico: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CRM do médico: ");
        String crm = scanner.nextLine();

        System.out.print("Digite a especialidade do médico: ");
        String especialidade = scanner.nextLine();

        
        Medico medico = new Medico(id, nome, crm, especialidade);

        
        try (Connection conn = Database.connect()) {
            String sql = "INSERT INTO Medico (id, nome, crm, especialidade) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, medico.getId());
                stmt.setString(2, medico.getNome());
                stmt.setString(3, medico.getCrm());
                stmt.setString(4, medico.getEspecialidade());

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("\n✅ Médico cadastrado com sucesso no banco de dados!");
                }
            }
        } catch (SQLException e) {
            System.out.println("❌ Erro ao conectar ao banco de dados: " + e.getMessage());
        }

        scanner.close();
    }
}
