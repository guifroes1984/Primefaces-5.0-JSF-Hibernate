package br.com.drograria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drograria.domain.Fabricante;
import br.com.drograria.domain.Produto;
import br.com.drograria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ProdutoBean {
	
	private Produto produtoCadastro;
	
	private List<Produto> listaProdutos;
	private List<Produto> listaProdutoFiltrados;
	
	private String acao;
	private Long codigo;
	
	private List<Fabricante> listaFabricantes;
	
	public List<Fabricante> getListaFabricantes() {
		return listaFabricantes;
	}

	public void setListaFabricantes(List<Fabricante> listaFabricantes) {
		this.listaFabricantes = listaFabricantes;
	}

	public Produto getProdutoCadastro() {
		return produtoCadastro;
	}

	public void setProdutoCadastro(Produto produtoCadastro) {
		this.produtoCadastro = produtoCadastro;
	}

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

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void novo() {
		produtoCadastro = new Produto();
	}
	
	public void salvar() {

		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.salvar(produtoCadastro);

			produtoCadastro = new Produto();

			FacesUtil.adicionarMsgInfo("Produto salvo com sucesso.");
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar salvar um produto: " + e.getMessage());
		}

	}
	
	public void carregarPesquisa() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			listaProdutos = produtoDAO.listar();
			
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os produtos: " + e.getMessage());
		}
	}
	
	public void carregarCadastro() {
		try {
			
			if (codigo != null) {
				ProdutoDAO produtoDAO = new ProdutoDAO();
				produtoCadastro = produtoDAO.buscarPorCodigo(codigo);
				
			}else {
				produtoCadastro = new Produto();
			}
			
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			listaFabricantes = fabricanteDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar obter os dados do fabricante: " + e.getMessage());
		}
	}
	
	public void excluir() {

		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.excluir(produtoCadastro);

			FacesUtil.adicionarMsgInfo("Produto removido com sucesso.");
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar remover o produto: " + e.getMessage());
		}

	}
	
	public void editar() {

		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.editar(produtoCadastro);

			FacesUtil.adicionarMsgInfo("Produto editado com sucesso.");
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar editar os dados do produto: " + e.getMessage());
		}

	}

}
