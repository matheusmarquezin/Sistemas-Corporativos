package com.produtos.produtosapp.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "produtoCompras", types = Produto.class)
public interface ProdutoCompras {
	
	@Value("#{target.id}")
	long getIdProduto();
	String getNome();
	double getPrecoVenda();
	String getNomeUnidadeMedida();

}
