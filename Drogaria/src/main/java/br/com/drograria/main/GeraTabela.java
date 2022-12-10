package br.com.drograria.main;

import br.com.drograria.util.HibernateUtil;

public class GeraTabela {

	public static void main(String[] args) {
		
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}

}
