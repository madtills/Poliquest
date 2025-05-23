
package com.siqueira.programacao_banco_de_dados_poliquest.modelo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Turma {
    private int id;
    private String nome;
    Turma(int id){
        this.id = id;
    }
}
