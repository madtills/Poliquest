
package com.mycompany.jogomilhao.Persistencia;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private String host = "poliquest-bd-beatrizdesiqueiraf-fcca.f.aivencloud.com";
    private String port = "16248";
    private String db = "defaultdb";
    private String user = "avnadmin";
    private String password = "AVNS_pXX1DwkHT7cZ8lT_zEH";
    
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