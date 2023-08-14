package com.notes.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {

	private static SessionFactory sf = null ;
	
	public static SessionFactory getSessionFactory() {
		
		try {
			if(sf==null) {
				sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	  return sf;	
	}
	
	public static void closeFactory() {
		if(sf.isOpen()) {
			sf.close();
		}
	}
}
