
package com.mycompany.jogomilhao.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private String host = "poliquest-bd-beatrizdesiqueiraf-fcca.f.aivencloud.com";
    private String port = "16248";
    private String db = "defaultdb";
    private String user = "avnadmin";
    private String password = "AVNS_pXX1DwkHT7cZ8lT_zEH";

    public Connection obterConexao() throws Exception {
        String url = String.format("jdbc:mysql://%s:%s/%s", host, port, db);
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) throws Exception {
        var fabricaDeConexoes = new ConnectionFactory();
        Connection conexao = fabricaDeConexoes.obterConexao();
        if (conexao != null) {
            System.out.println("Conectou!");
        } else {
            System.out.println("Não conectou");
        }
    }
}
