package com.siqueira._maua_tti101_t1_sub3_sistema_academico.persistencia;

import com.siqueira._maua_tti101_t1_sub3_sistema_academico.modelo.Curso;
import com.siqueira._maua_tti101_t1_sub3_sistema_academico.modelo.Usuario;
import java.util.*;
        
public class DAO {
    public boolean existe(Usuario u) throws Exception{
        //1. Definir o comando SQL (SELECT)
        var sql = "SELECT login, senha FROM tb_usuario WHERE login=? AND senha=?";
        //2. Estabelecer uma conexão com o SGBD
        //3. Preparar o comando 
        //try-with-resources
        try(
            var conexao = new ConnectionFactory().obterConexao();
            var ps = conexao.prepareStatement(sql);
        ){
        //4. Substituir os eventuais placeholders
        ps.setString(1, u.getLogin());
        ps.setString(2, u.getSenha());
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
    public List <Curso> obterCursos() throws Exception{
        var cursos = new ArrayList <Curso>(); //em python -> curso = []
        var sql = "SELECT * FROM tb_curso";
        //try-with-resources
        try(
            var conexao = new ConnectionFactory().obterConexao();
            var ps = conexao.prepareStatement(sql);
            var rs = ps.executeQuery();
        ){
            while(rs.next()){
                var codigo = rs.getInt("cod_curso");
                var nome = rs.getString("nome");
                var tipo = rs.getString("tipo");
                var curso = new Curso(codigo, nome, tipo);
                cursos.add(curso);
            }
            return cursos;
        }
    }
    public void cadastrar (Curso curso) throws Exception{
        //1. Especificar comando SQL
        var sql = "INSERT INTO tb_curso (nome, tipo) VALUES (?, ?);";
        //2. Conexão com o banco
        //3. Preparar o comando
        try(
            var conexao = new ConnectionFactory().obterConexao();
            var ps = conexao.prepareStatement(sql);
        ){
        //4. Sbustituir os eventuais placeholders
        ps.setString(1, curso.getNome());
        ps.setString(2, curso.getTipo());
        //5. Executar o comando
        ps.execute();
        //6. Fechar os recursos
        //já foi feito com o try-with-resources
        }
    }
}
