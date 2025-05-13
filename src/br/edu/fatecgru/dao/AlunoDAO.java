package br.edu.fatecgru.dao;

import br.edu.fatecgru.model.Aluno;
import br.edu.fatecgru.model.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoDAO {
    private Connection conexao;
    public AlunoDAO() {
    	
    }

    public AlunoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void salvar(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO aluno (nome, cpf, ra, data_nasc, endereco, email, municipio, uf, celular, curso_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getRA());
            stmt.setString(4, aluno.getDataNasc());
            stmt.setString(5, aluno.getEndereco());
            stmt.setString(6, aluno.getEmail());
            stmt.setString(7, aluno.getMunicipio());
            stmt.setString(8, aluno.getUf());
            stmt.setString(9, aluno.getCelular());

            Curso curso = aluno.getCurso();
            if (curso != null && curso.getId() != null) {
                stmt.setInt(10, curso.getId());
            } else {
                stmt.setNull(10, java.sql.Types.INTEGER);
            }

            stmt.executeUpdate();

            var rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                aluno.setId(rs.getInt(1));
            }
        }
    }
    public void alterar(Aluno aluno) throws SQLException {
        // Ajuste do SQL - não usar concatenação
        String sql = "UPDATE aluno SET nome = ?, cpf = ?, ra = ?, data_nasc = ?, endereco = ?, email = ?, municipio = ?, uf = ?, "
                + "celular = ?, curso_id = ? WHERE ra = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            // Configura os parâmetros de maneira correta
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getRA());
            stmt.setString(4, aluno.getDataNasc());
            stmt.setString(5, aluno.getEndereco());
            stmt.setString(6, aluno.getEmail());
            stmt.setString(7, aluno.getMunicipio());
            stmt.setString(8, aluno.getUf());
            stmt.setString(9, aluno.getCelular());

            Curso curso = aluno.getCurso();
            if (curso != null && curso.getId() != null) {
                stmt.setInt(10, curso.getId());
            } else {
                stmt.setNull(10, java.sql.Types.INTEGER);  // Se não houver curso, define como NULL
            }

            // Garantir que o RA está sendo corretamente passado como chave de busca para o WHERE
            stmt.setString(11, aluno.getRA());  // O RA que estamos buscando para alterar

            // Executa o update
            int rowsAffected = stmt.executeUpdate();

            // Verificar se a atualização foi bem-sucedida
            if (rowsAffected == 0) {
                System.out.println("Nenhum registro alterado, verifique se o RA existe.");
            } else {
                System.out.println("Aluno alterado com sucesso!");
            }
        } catch (SQLException e) {
            // Adicionando um bloco de captura para SQLExceptions, que ajuda a entender o erro.
            e.printStackTrace();
            throw e;
        }
    }
    public Aluno consultar(String ra) throws SQLException {
        String sql = "SELECT a.id, a.nome, a.cpf, a.ra, a.data_nasc, a.endereco, a.email, a.municipio, a.uf, a.celular " +
                     "FROM aluno a " +                     
                     "WHERE a.ra = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, ra);  // Define o RA do aluno a ser consultado

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Aluno aluno = new Aluno();
                    aluno.setId(rs.getInt("id"));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setCpf(rs.getString("cpf"));
                    aluno.setRA(rs.getString("ra"));
                    aluno.setDataNasc(rs.getString("data_nasc"));
                    aluno.setEndereco(rs.getString("endereco"));
                    aluno.setEmail(rs.getString("email"));
                    aluno.setMunicipio(rs.getString("municipio"));
                    aluno.setUf(rs.getString("uf"));
                    aluno.setCelular(rs.getString("celular"));

                    // Recuperando o curso associado ao aluno
//                    Curso curso = new Curso();
//                    curso.setId(rs.getInt("curso_id"));
//                    curso.setNomeCurso(rs.getString("nomeCurso"));
//                    aluno.setCurso(curso);

                    return aluno;
                } else {
                    return null;  // Retorna null caso não encontre o aluno
                }
            }catch (SQLException e) {
            	e.printStackTrace();
                throw e;
            }
        }
    }
    public void excluir(String ra) throws SQLException {
        String sql = "DELETE FROM aluno WHERE ra = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, ra);  // Define o ID do aluno a ser excluído
            stmt.executeUpdate();
        }
    }


    
    

}