package com.siqueira._maua_tti101_t1_sub3_pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PessoaDAO { //DAO: Data Access Object
    public void cadastrar(Pessoa pessoa) throws Exception{
        //1. Especificar o comando SQL (INSERT)
        var sql = "INSERT INTO tb_pessoa (nome, fone, email) VALUES (?, ?, ?)";
        //2. Obter uma conexao com o banco de dados
        var fabricaDeConexoes = new ConnectionFactory();
        Connection conexao = fabricaDeConexoes.obterConexao();
        //3. Preparar o comando
        PreparedStatement ps = conexao.prepareStatement(sql);
        //4. Substituir os eventuais placeholders (?)
        ps.setString(1, pessoa.getNome());
        ps.setString(2, pessoa.getFone());
        ps.setString(3, pessoa.getEmail());
        //5. Executar comando
        ps.execute();
        //6. Fechar a conexão
        ps.close();
        conexao.close();
    }
}
