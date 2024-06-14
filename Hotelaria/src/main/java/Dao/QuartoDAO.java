package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Quarto;

public class QuartoDAO {
    private Connection connection;

    // Construtor para inicializar a conexão com o banco de dados
    public QuartoDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para adicionar um quarto
    public void adicionarQuarto(Quarto quarto) throws SQLException {
        String sql = "INSERT INTO quarto (tipo, capacidade, andar, descricao, disponibilidade, diaria, facilidades) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, quarto.getTipo());
            stmt.setInt(2, quarto.getCapacidade());
            stmt.setInt(3, quarto.getAndar());
            stmt.setString(4, quarto.getDescricao());
            stmt.setString(5, quarto.getDisponibilidade());
            stmt.setDouble(6, quarto.getDiaria());
            stmt.setString(7, quarto.getFacilidades());
            stmt.executeUpdate();
        }
    }

    // Método para atualizar um quarto
    public void atualizarQuarto(Quarto quarto) throws SQLException {
        String sql = "UPDATE quarto SET tipo = ?, capacidade = ?, andar = ?, descricao = ?, disponibilidade = ?, diaria = ?, facilidades = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, quarto.getTipo());
            stmt.setInt(2, quarto.getCapacidade());
            stmt.setInt(3, quarto.getAndar());
            stmt.setString(4, quarto.getDescricao());
            stmt.setString(5, quarto.getDisponibilidade());
            stmt.setDouble(6, quarto.getDiaria());
            stmt.setString(7, quarto.getFacilidades());
            stmt.setInt(8, quarto.getId());
            stmt.executeUpdate();
        }
    }

    // Método para deletar um quarto
    public void deletarQuarto(int id) throws SQLException {
        String sql = "DELETE FROM quarto WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
