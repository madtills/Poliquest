package com.siqueira._maua_tti101_t1_sub3_pessoa;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    
    private String host = "localhost";
    private String port = "3306";
    private String db = "20251_maua_tti101_t1_sub3_pessoas";
    private String user = "root";
    private String password = "imtdb";
    
    public Connection obterConexao() throws Exception{
        //String de conexão
        //cláusula catch or declare
        var s = String.format(
            "jdbc:mysql://%s:%s/%s",
            host, port, db
        );
        Connection c = DriverManager.getConnection(s, user, password);
        return c;
    }
    
    public static void main(String[] args) throws Exception {
        var fabricaDeConexoes = new ConnectionFactory();
        var conexao = fabricaDeConexoes.obterConexao();
        if (conexao != null){
            System.out.println("Conectou!");
        }
        else{
            System.out.println("Não Conectou");
        }
    }
}
