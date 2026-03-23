package com.crudrodrigopronto.crudrodrigopronto.service;


import com.crudrodrigopronto.crudrodrigopronto.exception.ProdutoNaoEcontradoException;
import com.crudrodrigopronto.crudrodrigopronto.model.Produto;
import com.crudrodrigopronto.crudrodrigopronto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

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
        return Optional.of(produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNaoEcontradoException("Produto não encontrado")));
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public Optional<Produto> atualizarProduto(Long id, Produto produtoAtualizado) {
        return produtoRepository.findById(id)
                .map(p -> {
                    p.setNome(produtoAtualizado.getNome());
                    p.setPreco(produtoAtualizado.getPreco());
                    return produtoRepository.save(p); // 🔥 salva no banco
                });
    }
}