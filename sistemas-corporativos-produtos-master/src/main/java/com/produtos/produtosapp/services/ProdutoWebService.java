package com.produtos.produtosapp.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.produtosapp.model.Produto;
import com.produtos.produtosapp.repository.ProdutoRepository;


@Service
@RestController
@RequestMapping("/produtos")
public class ProdutoWebService {
	
	@Autowired
	ProdutoRepository pr;
	
	@PostMapping
	@RequestMapping(value = "/cadastrarProduto", method = RequestMethod.POST)
	public void persistirProduto(@RequestBody Produto produto) {
		pr.save(produto);
		System.out.println("Produto cadastrado com sucesso!");
	}
	
	@GetMapping
	@RequestMapping(value = "/{nome}", method = RequestMethod.GET)
    public List<Produto> listaProduto(@PathVariable("nome") String nome, Model model) {
          List<Produto> listaProdutos = pr.findByNome(nome);
          if (listaProdutos != null) {
                model.addAttribute("produtos", listaProdutos);
          }
          return listaProdutos;
    }
	
	@PutMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable("id") long id, @RequestBody Produto produto) {
        produto = pr.findOne(id);
        Produto prod = new Produto();
        pr.save(prod);
	}
     
	
	@DeleteMapping
	@RequestMapping(value = "/deletar/{nome}", method = RequestMethod.DELETE)
    public String deleteProduto(@PathVariable("nome") Produto nome) {
		Produto produto = pr.findByNome(nome);
		pr.delete(produto);
		return "OK";
    }
}
