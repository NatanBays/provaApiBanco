package org.senai.ecommerce.servico;

import org.senai.ecommerce.entities.Produto;
import org.senai.ecommerce.repository.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServico {

    private final ProdutoRepositorio produtoRepositorio;

    @Autowired
    public ProdutoServico(ProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    public List<Produto> getProdutos() {
        return produtoRepositorio.findAll();
    }

    public Optional<Produto> getProdutoPorCodigo(Long codigo) {
        return produtoRepositorio.findById(codigo);
    }

    public void criarProduto(Produto produto) {
        produtoRepositorio.save(produto);
    }

    public void atualizarProduto(Long codigo, Produto produtoDetalhes) {
        Optional<Produto> optionalTask = produtoRepositorio.findById(codigo);
        if (optionalTask.isPresent()) {
            Produto produtoExistente = optionalTask.get();
            produtoExistente.setNome(produtoDetalhes.getNome());
            produtoExistente.setDescricao(produtoDetalhes.getDescricao());
            produtoExistente.setPreco(produtoDetalhes.getPreco());
            produtoExistente.setEstoque(produtoDetalhes.getEstoque());
            produtoRepositorio.save(produtoExistente);
        }
    }

    public void deletarProduto(Long codigo) {
        produtoRepositorio.deleteById(codigo);
    }
}
