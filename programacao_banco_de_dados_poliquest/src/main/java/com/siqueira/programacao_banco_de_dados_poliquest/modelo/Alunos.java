
package com.siqueira.programacao_banco_de_dados_poliquest.modelo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor

public class Alunos {
    private String nome;
    private String ra;
    private String email;
    private String senha;
    private Turma turma;
    
}
