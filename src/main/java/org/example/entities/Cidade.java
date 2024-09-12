package org.example.entities;

public class Cidade {
    private int id;
    private String descricao;
    private int ddd;
    private String imagem;

    public Cidade(int id, String descricao, String imagem, int ddd) {
        this.id = id;
        this.descricao = descricao;
        this.imagem = imagem;
        this.ddd = ddd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
