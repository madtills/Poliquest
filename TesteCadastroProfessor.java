package com.siqueira.programacao_banco_de_dados_poliquest.modelo;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class TesteCadastroProfessor {
    public static void main(String[] args){
        var menu = "1-Cadastrar\n0-Sair";
        int op;
        do{
            op = parseInt(showInputDialog(menu));
            switch(op){
                case 1:
                    try{
                        var nome = showInputDialog("Nome?");
                        var email = showInputDialog("E-mail?");
                        var senha = showInputDialog("Senha?");
                        var professor = new Professor(nome, email, senha);
                        ProfessorDAO dao = new ProfessorDAO();
                        dao.cadastrarProfessor(professor);
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
