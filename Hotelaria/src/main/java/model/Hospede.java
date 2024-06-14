package model;

import java.time.LocalDate;

public class Hospede {
    private int id;
    private String nome;
    private LocalDate dataNascimento;
    private String genero;
    private String endereco;
    private int cep;
    private int telefone;
    private String email;
    private String pais;

    public Hospede(String nome, LocalDate dataNascimento, String genero, String endereco, int cep, int telefone, String email,String pais) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.endereco = endereco;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
        this.pais = pais;
    }

    // Getters and setters...

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Hospede{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", genero='" + genero + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cep=" + cep +
                ", telefone=" + telefone +
                ", email='" + email + '\'' +
                '}';
    }
}
