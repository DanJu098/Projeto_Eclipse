package br.edu.fatecgru.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CampusDAO {
	private Connection conexao;

    public CampusDAO(Connection conexao) {
        this.conexao = conexao;
    }
	public List<String> listarCampus() {
        List<String> campus = new ArrayList<>();
        String sql = "SELECT nome FROM campus";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                campus.add(rs.getString("nome"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar cursos: " + e.getMessage());
        }

        return campus;
    }

}
