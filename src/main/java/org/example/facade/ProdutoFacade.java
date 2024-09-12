package org.example.facade;

import org.example.applications.ProdutoApplication;
import org.example.entities.Cidade;

import java.util.ArrayList;

public class ProdutoFacade {
    private ProdutoApplication produtoApplication;

    public ProdutoFacade(ProdutoApplication produtoApplication) {
        this.produtoApplication = produtoApplication;
    }

    public void adicionar(Cidade cidade) {
        produtoApplication.adicionar(cidade);
    }

    public void remover(int id) {
        produtoApplication.remover(id);
    }

    public Cidade buscarPorId(int id) {
        return produtoApplication.buscarPorId(id);
    }

    public ArrayList<Cidade> buscarTodos(){
        return  this.produtoApplication.buscarTodos();
    }

    public void atualizarCidade(int id, Cidade cidade) {
        produtoApplication.atualizarCidade(id, cidade);
    }
}
