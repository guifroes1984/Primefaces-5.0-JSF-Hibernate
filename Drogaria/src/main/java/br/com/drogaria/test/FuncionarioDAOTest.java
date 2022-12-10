package br.com.drogaria.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drograria.domain.Funcionario;

public class FuncionarioDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf("333.333.333-33");
		funcionario.setFuncao("RECEPÇÃO");
		funcionario.setNome("BRUNA");
		funcionario.setSenha("1425");
		
		FuncionarioDAO dao = new FuncionarioDAO();
		
		dao.salvar(funcionario);

	}
	
	@Test
	@Ignore
	public void listar() {

		FuncionarioDAO dao = new FuncionarioDAO();

		List<Funcionario> funcionario = dao.listar();

		System.out.println(funcionario);
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario funcionario = dao.BuscarPorCodigo(2L);
		
		System.out.println(funcionario);
		
	}
	
	@Test
	@Ignore
	public void excluir() {

		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario funcionario = dao.BuscarPorCodigo(3L);

		dao.excluir(funcionario);

	}
	
	@Test
	public void editar() {
		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario funcionario = dao.BuscarPorCodigo(2L);
		
		funcionario.setCpf("444.444.444-44");
		funcionario.setFuncao("USUARIO");
		funcionario.setNome("JOSE");
		funcionario.setSenha("9876");

		dao.editar(funcionario);
	}

}
