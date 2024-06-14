package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Hospede;

public class HospedeDAO {
    private Connection connection;

    public HospedeDAO(Connection connection) {
        this.connection = connection;
    }

    String insertSql = "INSERT INTO hospede (nome, data_nascimento, genero, endereco, cep, telefone, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
    String updateSql = "UPDATE hospede SET nome = ?, data_nascimento = ?, genero = ?, endereco = ?, cep = ?, telefone = ?, email = ? WHERE id = ?";
    String deleteSql = "DELETE FROM hospede WHERE id = ?";
    String querySql = "SELECT * FROM hospede WHERE nome = ?";

    public void adicionarHospede(Hospede hospede) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
            ps.setString(1, hospede.getNome());
            ps.setDate(2, java.sql.Date.valueOf(hospede.getDataNascimento()));
            ps.setString(3, hospede.getGenero());
            ps.setString(4, hospede.getEndereco());
            ps.setInt(5, hospede.getCep());
            ps.setInt(6, hospede.getTelefone());
            ps.setString(7, hospede.getEmail());
            ps.setString(8, hospede.getPais());
            ps.executeUpdate();
        }
    }

    public void atualizarHospede(Hospede hospede) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(updateSql)) {
            ps.setString(1, hospede.getNome());
            ps.setDate(2, java.sql.Date.valueOf(hospede.getDataNascimento()));
            ps.setString(3, hospede.getGenero());
            ps.setString(4, hospede.getEndereco());
            ps.setInt(5, hospede.getCep());
            ps.setInt(6, hospede.getTelefone());
            ps.setString(7, hospede.getEmail());
            ps.setString(8, hospede.getPais());
            ps.setInt(9, hospede.getId());
            ps.executeUpdate();
        }
    }

    public void deletarHospede(int id) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(deleteSql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Hospede consultarHospede(String nome) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(querySql)) {
            ps.setString(1, nome);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Hospede(
                            rs.getString("nome"),
                            rs.getDate("data_nascimento").toLocalDate(),
                            rs.getString("genero"),
                            rs.getString("endereco"),
                            rs.getInt("cep"),
                            rs.getInt("telefone"),
                            rs.getString("email"),
                            rs.getString("pais")
                    );
                }
            }
        }
        return null;
    }
}
