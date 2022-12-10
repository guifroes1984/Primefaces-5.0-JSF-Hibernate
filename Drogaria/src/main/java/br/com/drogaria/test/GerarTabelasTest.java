package br.com.drogaria.test;

import org.junit.Test;

import br.com.drograria.util.HibernateUtil;

public class GerarTabelasTest {
	
	@Test
	public void gerar() {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}

}
