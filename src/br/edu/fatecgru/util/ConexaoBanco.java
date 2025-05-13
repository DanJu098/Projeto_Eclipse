package br.edu.fatecgru.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class ConexaoBanco {

    // URL do banco - ajuste o nome do banco, porta e host se necessário
//	private static final String URL = "jdbc:mysql://localhost:3306/cadalunodb?useSSL=false&serverTimezone=UTC";
//    private static final String USUARIO = "root";
//    private static final String SENHA = "";

    // Retorna uma conexão com o banco de dados
    public static Connection getConexao() throws Exception {
    	try {
			/*
			 * indica qual é o banco de dados que estou utilizando e seu driver
			 */
			Class.forName("com.mysql.jdbc.Driver");
// estabelece a conexao e retorna uma conexao
			String url = "jdbc:mysql://localhost:3306/cadalunodb";
			String user = "root";
			String senha = "";
			return DriverManager.getConnection(url, user, senha);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}      
    
}
}