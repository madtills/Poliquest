package com.siqueira._maua_tti101_t1_sub3_sistema_academico.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Curso {
    private int codigo;
    private String nome;
    private String tipo;
    
    public Curso(String nome, String tipo){
        this.nome = nome;
        this.tipo = tipo;
    }
    
    @Override //sobrescrita de método
    public String toString(){
        return String.format("%s - %s", nome, tipo);
    };
}
