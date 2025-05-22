
package com.mycompany.jogomilhao.Persistencia;

import com.mycompany.jogomilhao.TelaCadastro.Alunos;

public class AlunoDAO {
    
    public boolean existe(Alunos a) throws Exception{
        //1. Definir o comando SQL (SELECT)
        var sql = "SELECT ra, senha FROM aluno WHERE ra=? AND senha=?";
        //2. Estabelecer uma conexão com o SGBD
        //3. Preparar o comando 
        //try-with-resources
        try(
            var conexao = new ConnectionFactory().obterConexao();
            var ps = conexao.prepareStatement(sql);
        ){
        //4. Substituir os eventuais placeholders
        ps.setString(1, a.getRa());
        ps.setString(2, a.getSenha());
        //5. Executar o comando
        try(
            var rs = ps.executeQuery();
        ){
        //6. Lidar com o resultado
        return rs.next();
        //7. Fechar recursos
        //já foi feito com o try-with-resources
        }
        }
    }
    public void cadastrarAlunos(Alunos alunos) throws Exception{
        //1- Especificar o comando SQL(INSERT)
        var sql = "INSERT INTO aluno (nome, ra, email, senha) VALUES(?,?,?,?)";
        //2- Estabelecer uma conexao com o SGBD
        //3- Preparar o comando
        //try-with-resources
        try(
            var conexao = new ConnectionFactory().obterConexao();
            var ps = conexao.prepareStatement(sql);
        ){
            //4- Substituir eventuais placeholders
            ps.setString(1, alunos.getNome());
            ps.setString(2, alunos.getRa());
            ps.setString(3, alunos.getEmail());
            ps.setString(4, alunos.getSenha());
            //5- Executar comando
            ps.execute();
        }
    }
}   
