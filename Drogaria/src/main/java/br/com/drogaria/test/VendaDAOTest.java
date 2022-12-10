package br.com.drogaria.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.dao.VendaDAO;
import br.com.drograria.domain.Funcionario;
import br.com.drograria.domain.Venda;

public class VendaDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.BuscarPorCodigo(2L);
		
		Venda venda = new Venda();
		venda.setFuncionario(funcionario);
		venda.setHorario(new Date());
		venda.setValor(new BigDecimal(234.53D));
		
		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.salvar(venda);
	}
	
	@Test
	@Ignore
	public void listar() {
		VendaDAO vendaDAO = new VendaDAO();
		
		List<Venda> vendas = vendaDAO.listar();
		
		System.out.println(vendas);
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		VendaDAO vendaDAO = new VendaDAO();
		
		Venda venda = vendaDAO.buscarPorCodigo(1L);
		
		System.out.println(venda);
	}
	
	@Test
	@Ignore
	public void excluir() {
		VendaDAO vendaDAO = new VendaDAO();
		
		Venda venda = vendaDAO.buscarPorCodigo(1L);
		
		vendaDAO.excluir(venda);
	}
	
	@Test
	@Ignore
	public void editar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.BuscarPorCodigo(1L);
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(2L);
		
		venda.setHorario(new Date());
		venda.setValor(new BigDecimal(21.34D));
		venda.setFuncionario(funcionario);
		
		vendaDAO.editar(venda);
		
	}

}
