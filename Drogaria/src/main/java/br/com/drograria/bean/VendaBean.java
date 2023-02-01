package br.com.drograria.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drograria.domain.Item;
import br.com.drograria.domain.Produto;
import br.com.drograria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class VendaBean {

	private List<Produto> listaProdutos;
	private List<Produto> listaProdutoFiltrados;
	
	private List<Item> listaItens;

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public List<Produto> getListaProdutoFiltrados() {
		return listaProdutoFiltrados;
	}

	public void setListaProdutoFiltrados(List<Produto> listaProdutoFiltrados) {
		this.listaProdutoFiltrados = listaProdutoFiltrados;
	}
	
	public List<Item> getListaItens() {
		if (listaItens == null) {
			listaItens = new ArrayList<>();
		}
		return listaItens;
	}
	
	public void setListaItens(List<Item> listaItens) {
		this.listaItens = listaItens;
	}
	
	public void carregarProdutos() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			listaProdutos = produtoDAO.listar();
			
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os produtos: " + e.getMessage());
		}
	}
	
	public void adicionar(Produto produto) {
		Item item = new Item();
		item.setProduto(produto);
		item.setQuantidade(1);
		item.setValor(produto.getPreco());
		
		System.out.println(item);
		
		listaItens.add(item);
	}

}
