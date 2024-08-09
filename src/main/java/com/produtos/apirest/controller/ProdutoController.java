package com.produtos.apirest.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Operation(description="Retorna uma lista de Produtos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna lista de produtos"),
	})
	@GetMapping(value = "/produtos")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@Operation(description="Retorna um produto unico")
	@GetMapping(value = "/produto/{id}")
	public Produto listaProdutoUnico(@PathVariable(value="id") long id){
		return produtoRepository.findById(id);
	}
	
	@Operation(description="Salva um produto")
	@PostMapping(value = "/produto")
	public Produto salvaProduto(@RequestBody @Valid Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@Operation(description="Deleta um produto")
	@DeleteMapping(value = "/produto")
	public void deletaProduto(@RequestBody @Valid Produto produto) {
		produtoRepository.delete(produto);
	}
	
	@Operation(description="Atualiza um produto")
	@PutMapping(value = "/produto")
	public Produto atualizaProduto(@RequestBody @Valid Produto produto) {
		return produtoRepository.save(produto);
	}
	 

}
