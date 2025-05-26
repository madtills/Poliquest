
package com.mycompany.jogomilhao.TelaCadastro;

public class Alunos {

    private String nome;
    private String ra; // Registro Acadêmico
    private String email;
    private String senha;

    // Construtor padrão (necessário para frameworks como JPA)
    public Alunos(int par, String ra1, String senha1) {
    }

    // Construtor completo
    public Alunos(String nome, String ra, String email, String senha) {
        this.nome = nome;
        this.ra = ra;
        this.email = email;
        this.senha = senha;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Alunos{" +
               "nome='" + nome + '\'' +
               ", ra='" + ra + '\'' +
               ", email='" + email + '\'' +
               ", senha='" + senha + '\'' +
               '}';
    }

}