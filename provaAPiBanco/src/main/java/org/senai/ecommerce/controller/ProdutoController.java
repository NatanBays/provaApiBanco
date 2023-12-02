package org.senai.ecommerce.controller;
import org.senai.ecommerce.entities.Produto;
import org.senai.ecommerce.servico.ProdutoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoServico produtoServico;


    @PreAuthorize("hasRole('PRODUCT_SELECT')")
    @GetMapping
    public List<Produto> getProdutos() {
        return produtoServico.getProdutos();
    }

    @GetMapping("/{codigo}")
    @PreAuthorize("hasRole('PRODUCT_SELECT')")
    public ResponseEntity<?> getProdutoPorCodigo(@PathVariable Long codigo) {
        return new ResponseEntity<>(produtoServico.getProdutoPorCodigo(codigo), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('PRODUCT_INSERT')")
    public ResponseEntity<?> criarProduto(@RequestBody Produto produto) {
        produtoServico.criarProduto(produto);
        return new ResponseEntity<>("Produto Criado", HttpStatus.CREATED);

    }

    @PutMapping("/{codigo}")
    @PreAuthorize("hasRole('PRODUCT_UPDATE')")
    public ResponseEntity<?> atualizarProduto(@PathVariable Long codigo, @RequestBody Produto produtoDetalhes) {
        produtoServico.atualizarProduto(codigo, produtoDetalhes);
        return new ResponseEntity<>("Produto Atualizado", HttpStatus.OK);
    }

    @DeleteMapping("/{codigo}")
    @PreAuthorize("hasRole('PRODUCT_DELETE')")
    public ResponseEntity<?> deletarProduto(@PathVariable Long codigo) {
        produtoServico.deletarProduto(codigo);
        return new ResponseEntity<>("Produto Deletado", HttpStatus.OK);
    }
}

