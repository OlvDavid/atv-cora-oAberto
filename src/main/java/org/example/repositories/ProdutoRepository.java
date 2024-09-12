package org.example.repositories;

import org.example.entities.Cidade;

import java.util.ArrayList;

public class ProdutoRepository {
    private ArrayList<Cidade> cidades = new ArrayList<Cidade>();

    public void adicionar(Cidade cidade) {
        cidades.add(cidade);
    }

    public void remover(int id){
        cidades.removeIf(cidade -> cidade.getId() ==id);
    }

    private Cidade filtrarCidade(int id){
        return cidades.stream().filter(cidade -> cidade.getId() == id).findFirst().orElse(null);
    }

    public Cidade buscarPorId(int id){
        Cidade cidadeInDb = filtrarCidade(id);

        return cidadeInDb;
    }

    public ArrayList<Cidade> buscarCidades(){
        return cidades;
    }

    public void atualizarCidade(int id, Cidade cidade){
        Cidade cidadeInDb = filtrarCidade(id);

        cidadeInDb.setDescricao(cidade.getDescricao());
        cidadeInDb.setDdd(cidade.getDdd());
        cidade.setImagem(cidade.getImagem());
    }
}
