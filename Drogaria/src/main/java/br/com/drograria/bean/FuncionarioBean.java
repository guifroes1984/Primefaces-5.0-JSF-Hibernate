package br.com.drograria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drograria.domain.Funcionario;
import br.com.drograria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FuncionarioBean {
	
	private Funcionario funcionarioCadastro;
	
	private List<Funcionario> listaFuncionarios;
	private List<Funcionario> listaFuncionariosFiltrados;
	
	private String acao;
	private Long codigo;
	
	public Funcionario getFuncionarioCadastro() {
		return funcionarioCadastro;
	}
	public void setFuncionarioCadastro(Funcionario funcionarioCadastro) {
		this.funcionarioCadastro = funcionarioCadastro;
	}
	public List<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}
	public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}
	public List<Funcionario> getListaFuncionariosFiltrados() {
		return listaFuncionariosFiltrados;
	}
	public void setListaFuncionariosFiltrados(List<Funcionario> listaFuncionariosFiltrados) {
		this.listaFuncionariosFiltrados = listaFuncionariosFiltrados;
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
		funcionarioCadastro = new Funcionario();
	}
	
	public void salvar() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.salvar(funcionarioCadastro);
			
			funcionarioCadastro = new Funcionario();
			
			FacesUtil.adicionarMsgInfo("Funcionário salvo com sucesso");
		} catch (RuntimeException e) {
			FacesUtil.adicionarMsgErro("Erro ao tentar salvar os dados do funcionário: " + e.getCause());
		}
	}
	
	public void carregarPesquisa() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			listaFuncionarios = funcionarioDAO.listar();
			
		} catch (RuntimeException e) {
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os funcionário: " + e.getMessage());
		}
	}
	
	public void carregarCadastro() {
		try {
			
			if (codigo != null) {
				FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
				funcionarioCadastro = funcionarioDAO.BuscarPorCodigo(codigo);
				
			}else {
				funcionarioCadastro = new Funcionario();
			}
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar obter os dados do fabricante: " + e.getMessage());
		}
	}
	
	public void excluir() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.excluir(funcionarioCadastro);

			FacesUtil.adicionarMsgInfo("Fabricante removido com sucesso.");
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar remover o fabricante: " + e.getMessage());
		}

	}
	
	public void editar() {

		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.editar(funcionarioCadastro);

			FacesUtil.adicionarMsgInfo("Fabricante editado com sucesso.");
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar editar os dados do funcionário: " + e.getMessage());
		}

	}

}
