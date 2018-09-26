package com.produtos.produtosapp.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "produtoManufatura", types = Produto.class)
public interface ProdutoManufatura {
	
	@Value("#{target.id}")
	long getIdProduto();
	String getNome();
	double getPrecoVenda();
	String getNomeUnidadeMedida();
	String getTamanhoProduto();

}
