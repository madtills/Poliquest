package com.siqueira._maua_tti101_t1_sub3_sistema_academico.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionFactory {
    
    private String host = "localhost";
    private String port = "3306";
    private String db = "20251_maua_tti101_t1_sub3_sistema_academico";
    private String user = "root";
    private String password = "imtdb";//imtdb --> senha da mauá
    
    //http://google.com.br:80/search
    
    public Connection obterConexao() throws Exception{
        var s = String.format(
            "jdbc:mysql://%s:%s/%s",
            host, port, db
        );
        //cláusula catch or declare
        Connection c = DriverManager.getConnection(s, user, password);
        return c;
    }
    
    public static void main(String[] args) throws Exception {
        var fabricaDeConexoes = new ConnectionFactory();
        //cláusula catch or declare
        Connection conexao = fabricaDeConexoes.obterConexao();
        if(conexao != null){
            System.out.println("Conectou!");
        }
        else{
            System.out.println("Não conectou");
        }
    }
    
}