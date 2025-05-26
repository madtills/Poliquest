package com.mycompany.jogomilhao.Persistencia;

import com.mycompany.jogomilhao.TelaCadastro.Alunos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoDAO {

    public boolean existe(Alunos aluno) throws Exception {
        boolean resultado = false;
        String sql = "SELECT * FROM aluno WHERE ra = ? AND senha = ?";

        try (
            Connection conn = new ConnectionFactory().obterConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, aluno.getRa());
            stmt.setString(2, aluno.getSenha());

            ResultSet rs = stmt.executeQuery();
            resultado = rs.next(); // se houver resultado, o aluno existe

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }

    public void cadastrarAlunos(Alunos alunos) throws Exception {
        String sql = "INSERT INTO aluno (nome, ra, email, senha) VALUES (?, ?, ?, ?)";

        try (
            Connection conexao = new ConnectionFactory().obterConexao();
            PreparedStatement ps = conexao.prepareStatement(sql)
        ) {
            ps.setString(1, alunos.getNome());
            ps.setString(2, alunos.getRa());
            ps.setString(3, alunos.getEmail());
            ps.setString(4, alunos.getSenha());

            ps.execute();
        }
    }
}
