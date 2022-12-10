package br.com.drogaria.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drograria.domain.Fabricante;

public class FabricanteDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Fabricante f1 = new Fabricante();
		f1.setDescricao("DESCRICAO 3");

		Fabricante f2 = new Fabricante();
		f2.setDescricao("DESCRICAO 4");

		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(f1);
		dao.salvar(f2);

	}

	@Test
	@Ignore
	public void listar() {

		FabricanteDAO dao = new FabricanteDAO();

		List<Fabricante> fabricantes = dao.listar();

		System.out.println(fabricantes);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		FabricanteDAO dao = new FabricanteDAO();

		Fabricante f1 = dao.BuscarPorCodigo(1L);
		Fabricante f2 = dao.BuscarPorCodigo(3L);

		System.out.println(f1);
		System.out.println(f2);
	}

	@Test
	@Ignore
	public void excluir() {

		FabricanteDAO dao = new FabricanteDAO();

		Fabricante fabricante = dao.BuscarPorCodigo(7L);

		dao.excluir(fabricante);

	}

	@Test
	@Ignore
	public void editar() {
		FabricanteDAO dao = new FabricanteDAO();

		Fabricante fabricante = dao.BuscarPorCodigo(8L);
		
		fabricante.setDescricao("UPDATE 1");

		dao.editar(fabricante);
	}

}
