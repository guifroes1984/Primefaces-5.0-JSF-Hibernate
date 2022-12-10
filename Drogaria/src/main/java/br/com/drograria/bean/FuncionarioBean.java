package br.com.drograria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drograria.domain.Funcionario;
import br.com.drograria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FuncionarioBean {
	
	private Funcionario funcionarioCadastro;
	
	public Funcionario getFuncionarioCadastro() {
		if (funcionarioCadastro == null) {
			funcionarioCadastro = new Funcionario();
		}
		return funcionarioCadastro;
	}
	
	public void setFuncionarioCadastro(Funcionario funcionarioCadastro) {
		this.funcionarioCadastro = funcionarioCadastro;
	}
	
	public void salvar() {
		FacesUtil.adicionarMsgInfo(funcionarioCadastro.toString());
		FacesUtil.adicionarMsgInfo("Funcionário salvo com sucesso.");
	}

}
