
package com.siqueira.programacao_banco_de_dados_poliquest.modelo;

//import com.mycompany.jogomilhao.TelaCadastro.Alunos;
import com.siqueira.programacao_banco_de_dados_poliquest.persistencia.ConnectionFactory;

public class AlunoDAO {
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
