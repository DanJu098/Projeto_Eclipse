package br.edu.fatecgru.dao;

import br.edu.fatecgru.model.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;


public class CursoDAO {
    private Connection conexao;

    public CursoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void salvar(Curso curso) throws SQLException {
        String sql = "INSERT INTO curso (campus, periodo, disciplina_id) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, curso.getCampus());
            stmt.setString(2, curso.getPeriodo());

            if (curso.getDisciplina() != null && curso.getDisciplina().getId() != null) {
                stmt.setInt(3, curso.getDisciplina().getId());
            } else {
                stmt.setNull(3, java.sql.Types.INTEGER);
            }

            ResultSet rs = stmt.getGeneratedKeys(); // CORRIGIDO
            if (rs.next()) {
                curso.setId(rs.getInt(1)); // CORRIGIDO
            }
        }
    }
    public List<String> listarCursos() {
        List<String> cursos = new ArrayList<>();
        String sql = "SELECT nome FROM curso";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                cursos.add(rs.getString("nome"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar cursos: " + e.getMessage());
        }

        return cursos;
    }
    
}