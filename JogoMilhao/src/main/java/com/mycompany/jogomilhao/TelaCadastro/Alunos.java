
package com.mycompany.jogomilhao.TelaCadastro;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor

public class Alunos {
    private int idAluno;
    private String nome;
    private String ra;
    private String email;
    private String senha;
    private int idTurma; //Verificar chave estrangeira 
}
