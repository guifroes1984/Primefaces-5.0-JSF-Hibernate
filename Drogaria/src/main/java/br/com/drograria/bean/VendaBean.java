package br.com.drograria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drograria.domain.Produto;
import br.com.drograria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class VendaBean {

	private List<Produto> listaProdutos;
	private List<Produto> listaProdutoFiltrados;

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
	
	public void carregarProdutos() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			listaProdutos = produtoDAO.listar();
			
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os produtos: " + e.getMessage());
		}
	}
	

}
