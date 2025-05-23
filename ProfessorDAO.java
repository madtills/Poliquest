package com.siqueira.programacao_banco_de_dados_poliquest.modelo;

import com.siqueira.programacao_banco_de_dados_poliquest.persistencia.ConnectionFactory;

public class ProfessorDAO {
    public void cadastrarProfessor(Professor professor) throws Exception{
        var sql = "INSERT INTO professor (nome, email, senha) VALUES (?, ?, ?)";
        try(
            var conexao = new ConnectionFactory().obterConexao();
            var ps = conexao.prepareStatement(sql);
                
        ){
            ps.setString(1, professor.getNome());
            ps.setString(2, professor.getEmail());
            ps.setString(3, professor.getSenha());
            ps.execute();
        }
    }
}
