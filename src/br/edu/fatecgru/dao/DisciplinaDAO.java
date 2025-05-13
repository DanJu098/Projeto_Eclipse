package br.edu.fatecgru.dao;

import br.edu.fatecgru.model.Disciplina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {

    private Connection conexao;

    public DisciplinaDAO(Connection conexao) {
        this.conexao = conexao;
    }

   
}
