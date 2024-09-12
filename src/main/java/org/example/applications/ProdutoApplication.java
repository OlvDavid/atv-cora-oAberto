package org.example.applications;

import org.example.entities.Cidade;
import org.example.repositories.ProdutoRepository;
import org.example.services.ProdutoService;

import java.util.ArrayList;

public class ProdutoApplication {
    private ProdutoRepository produtoRepository;
    private ProdutoService produtoService;

    public ProdutoApplication(ProdutoRepository produtoRepository, ProdutoService produtoService) {
        this.produtoRepository = produtoRepository;
        this.produtoService = produtoService;
    }

    public void adicionar(Cidade cidade) {
        this.produtoRepository.adicionar(cidade);
        this.produtoService.salvarImagem(cidade);
    }

    public void adicionarSoimagem(Cidade cidade) {
        this.produtoService.salvarImagem(cidade);
    }

    public void remover(int id){
        this.produtoRepository.remover(id);
        this.produtoService.removerImagem(id);
    }

    public Cidade buscarPorId(int id) {
        return this.produtoRepository.buscarPorId(id);
    }

    public ArrayList<Cidade> buscarTodos(){
        return this.produtoRepository.buscarCidades();
    }

    public void atualizarCidade(int id, Cidade cidade) {
        this.produtoRepository.atualizarCidade(id, cidade);
        this.produtoService.salvarImagem(cidade);
    }
}
