
package com.mycompany.jogomilhao.TelaCadastro;

// This class represents a student (Aluno) with their details.
public class Alunos {

    private String nome;
    private String ra; // Registro Acadêmico (Academic Record)
    private String email;
    private String senha; // Password

    // Default constructor (important for some frameworks like ORM)
    public Alunos() {
    }

    // Constructor with all fields
    public Alunos(String nome, String ra, String email, String senha) {
        this.nome = nome;
        this.ra = ra;
        this.email = email;
        this.senha = senha;
    }

    public Alunos(int i, String ra, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getter for nome (Name)
    public String getNome() {
        return nome;
    }

    // Setter for nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter for ra (Academic Record)
    public String getRa() {
        return ra;
    }

    // Setter for ra
    public void setRa(String ra) {
        this.ra = ra;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for senha (Password)
    public String getSenha() {
        return senha;
    }

    // Setter for senha
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