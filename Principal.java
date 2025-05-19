package com.siqueira._maua_tti101_t1_sub3_pessoa;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class Principal {
    public static void main(String[] args) throws Exception { //em teoria o main deve tratar a exceção, mas não deu tempo na aula
        var menu = "1 - Cadastrar\n2 - Atualizar\n3 - Remover\n4 - Listar\n0 - Sair";
        int op;
        do{
            op = parseInt(showInputDialog(menu));
            switch(op){
                case 1:
                    var nome = showInputDialog("Nome?");
                    var fone = showInputDialog("Fone?");
                    var email = showInputDialog("Email?");
                    var pessoa = new Pessoa(nome, fone, email);
                    PessoaDAO dao = new PessoaDAO();
                    dao.cadastrar(pessoa);
                    showMessageDialog(null, "Cadastrou!");
                    break;
            }
        }while(op != 0);
    }
}
