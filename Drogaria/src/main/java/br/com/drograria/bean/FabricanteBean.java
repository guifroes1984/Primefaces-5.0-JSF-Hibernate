package br.com.drograria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drograria.domain.Fabricante;
import br.com.drograria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FabricanteBean {

	private Fabricante fabricanteCadastro;

	private List<Fabricante> listaFabricante;
	private List<Fabricante> listaFabricantesFiltrados;
	
	private String acao;
	private Long codigo;
	

	public Fabricante getFabricanteCadastro() {
		return fabricanteCadastro;
	}

	public void setFabricanteCadastro(Fabricante fabricanteCadastro) {
		this.fabricanteCadastro = fabricanteCadastro;
	}

	public List<Fabricante> getListaFabricante() {
		return listaFabricante;
	}

	public void setListaFabricante(List<Fabricante> listaFabricante) {
		this.listaFabricante = listaFabricante;
	}

	public List<Fabricante> getListaFabricantesFiltrados() {
		return listaFabricantesFiltrados;
	}

	public void setListaFabricantesFiltrados(List<Fabricante> listaFabricantesFiltrados) {
		this.listaFabricantesFiltrados = listaFabricantesFiltrados;
	}
	
	public String getAcao() {
		return acao;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}

	public void novo() {
		fabricanteCadastro = new Fabricante();
	}
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void salvar() {

		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.salvar(fabricanteCadastro);

			fabricanteCadastro = new Fabricante();

			FacesUtil.adicionarMsgInfo("Fabricante salvo com sucesso.");
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar salvar um fabricante: " + e.getMessage());
		}

	}
	
	public void carregarPesquisa() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			listaFabricante = fabricanteDAO.listar();
			
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os fabricantes: " + e.getMessage());
		}
	}
	
	public void carregarCadastro() {
		try {
			
			if (codigo != null) {
				FabricanteDAO fabricanteDAO = new FabricanteDAO();
				fabricanteCadastro = fabricanteDAO.BuscarPorCodigo(codigo);
				
			}else {
				fabricanteCadastro = new Fabricante();
			}
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar obter os dados do fabricante: " + e.getMessage());
		}
	}
	
	public void excluir() {

		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.excluir(fabricanteCadastro);

			FacesUtil.adicionarMsgInfo("Fabricante removido com sucesso.");
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar remover o fabricante: " + e.getMessage());
		}

	}
	
	public void editar() {

		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.editar(fabricanteCadastro);

			FacesUtil.adicionarMsgInfo("Fabricante editado com sucesso.");
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar editar os dados do fabricante: " + e.getMessage());
		}

	}

}
