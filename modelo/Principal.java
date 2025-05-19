package com.siqueira.programacao_banco_de_dados_poliquest.modelo;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
public class Principal {
    public static void main(String[] args){
        var menu = "1-Cadastrar\n0-Sair";
        int op;
        do{
            op = parseInt(showInputDialog(menu));
            switch(op){
                case 1:
                    try{
                        var nome = showInputDialog("Nome?");
                        var ra = showInputDialog("Ra?");
                        var email = showInputDialog("E-mail?");
                        var senha = showInputDialog("Senha?");
                        var aluno = new Alunos(nome, ra, email, senha);
                        AlunoDAO dao = new AlunoDAO();
                        dao.cadastrarAlunos(aluno);
                        showMessageDialog(null, "Cadastrou!");
                    }
                    catch(Exception e){
                        e.printStackTrace();
                        showMessageDialog(null, "Tente novamente mais tarde");
                    }
                    break;
            }
        }while(op != 0);
    }
}
