package br.com.drogaria.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drograria.domain.Fabricante;
import br.com.drograria.domain.Produto;

public class ProdutoDAOTest {

	@Test
	@Ignore
	public void inserir() {
		FabricanteDAO fdao = new FabricanteDAO();

		Fabricante fabricante = fdao.BuscarPorCodigo(8L);

		Produto produto = new Produto();
		produto.setDescricao("BBBBBBBBBBB");
		produto.setPreco(new BigDecimal(12.45));
		produto.setQuantidade(12);
		produto.setFabricante(fabricante);

		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		Produto produto = produtoDAO.buscarPorCodigo(2L);
		
		System.out.println(produto);
		
	}
	
	@Test
	@Ignore
	public void listar() {
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		List<Produto> produtos = produtoDAO.listar();
		
		System.out.println(produtos);
		
	}
		
	@Test
	@Ignore
	public void excluir() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		Produto produto = produtoDAO.buscarPorCodigo(2L);
		
		produtoDAO.excluir(produto);
	}
	
	@Test
	@Ignore
	public void editar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		Produto produto = produtoDAO.buscarPorCodigo(3L);
		
		produto.setDescricao("DESCRICAO EDITANDO 2");
		produto.setPreco(new BigDecimal(2.22));
		produto.setQuantidade(2);
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.BuscarPorCodigo(4L);
		produto.setFabricante(fabricante);
		
		produtoDAO.editar(produto);
	}
			
}
