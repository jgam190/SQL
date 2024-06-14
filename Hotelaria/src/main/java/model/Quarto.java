package model;

public class Quarto {
    private int id;
    private String tipo;
    private int capacidade;
    private int andar;
    private String descricao;
    private String disponibilidade;
    private double diaria;
    private String facilidades;

    // Construtor
    public Quarto(int id, String tipo, int capacidade, int andar, String descricao, String disponibilidade, double diaria, String facilidades) {
        this.id = id;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.andar = andar;
        this.descricao = descricao;
        this.disponibilidade = disponibilidade;
        this.diaria = diaria;
        this.facilidades = facilidades;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public double getDiaria() {
        return diaria;
    }

    public void setDiaria(double diaria) {
        this.diaria = diaria;
    }

    public String getFacilidades() {
        return facilidades;
    }

    public void setFacilidades(String facilidades) {
        this.facilidades = facilidades;
    }
}
