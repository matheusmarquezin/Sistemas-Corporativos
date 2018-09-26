package com.produtos.produtosapp.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "produtoVendas", types = Produto.class)
public interface ProdutoVendas {

	@Value("#{target.id}")
	long getIdProduto();
	String getNome();
	double getValor();
}
