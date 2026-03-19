package com.crudrodrigopronto.crudrodrigopronto.service;


import com.crudrodrigopronto.crudrodrigopronto.model.Produto;
import com.crudrodrigopronto.crudrodrigopronto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public Optional<Produto> atualizarProduto(Long id, Produto produtoAtualizado) {
        return listarProdutos().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(p -> {
                    p.setNome(produtoAtualizado.getNome());
                    p.setPreco(produtoAtualizado.getPreco());
                    return p;
                });
    }
}