package com.produtos.produtosapp.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "produtoInventario", types = Produto.class)
public interface ProdutoInventario {
	
	@Value("#{target.id}")
	long getIdProduto();
	String getNome();
	double getProdutoCategoria();
	int getNivelEstoque();
}
