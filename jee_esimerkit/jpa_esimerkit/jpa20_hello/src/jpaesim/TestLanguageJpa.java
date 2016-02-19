package jpaesim;

import java.util.List;

import javax.persistence.*;

public class TestLanguageJpa {

	public static void main(String[] args) {
		 EntityManagerFactory tehdas = Persistence.createEntityManagerFactory("jpa_hello");
	        EntityManager manageri = tehdas.createEntityManager();

	        EntityTransaction transaktio = manageri.getTransaction();	        
	        transaktio.begin();

	        Language l1 = new Language();
	        l1.setName("Englanti");
	        l1.setCode("en");
	        
	        Language l2 = new Language();
	        l2.setName("Ruotsi");
	        l2.setCode("se");
	        Language l3 = new Language();
	        l3.setName("Suomi");
	        l3.setCode("fi");

	        manageri.persist(l1);
	        manageri.persist(l2);
	        manageri.persist(l3);
	        
	        transaktio.commit();

	        // Testihaku - haetaan ja tulostetaan kaikki kannassa olevat Language-entiteetit
	        @SuppressWarnings("unchecked")
			List<Language> entiteetit = manageri.createNamedQuery("selectAll").getResultList();
	        for (Language e : entiteetit) {
	            System.out.println("Rivi: " + e.getName());
	        }

	        manageri.close();
	        tehdas.close();

	}

}
