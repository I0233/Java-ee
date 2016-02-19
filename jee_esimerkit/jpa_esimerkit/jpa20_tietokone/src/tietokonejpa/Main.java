package tietokonejpa;

import javax.persistence.*;
import java.util.*;

class Main {
	public static void main(String[] args) {

		EntityManagerFactory tehdas = Persistence
				.createEntityManagerFactory("jpa_tietokone");
		EntityManager manageri = tehdas.createEntityManager();

		EntityTransaction transaktio = manageri.getTransaction();

		transaktio.begin();

		Tietokone p1 = new Tietokone();
		p1.setMerkki("Hp"); 
		p1.setMalli("Elitebook");
		Tietokone p2 = new Tietokone();
		p2.setMerkki("Lenovo");
		p2.setMalli("ThinkPad");		
		Tietokone p3 = new Tietokone();
		p3.setMerkki("Acorn");
		p3.setMalli("BBC Micro");
		Tietokone p4 = new Tietokone();
		p4.setMerkki("Sinclair");
		p4.setMalli("Spectrum");

		manageri.persist(p1);
		manageri.persist(p2);
		manageri.persist(p3);
		manageri.persist(p4);

		transaktio.commit();
		
		// haetaan ja tulostetaan kaikki kannassa olevat Tietokone-entiteetit
		@SuppressWarnings("unchecked")
		List<Tietokone> entiteetit = manageri.createNamedQuery("haeKaikki")
				.getResultList();
		for (Tietokone e : entiteetit) {
			System.out.println("Rivi: " + e.getMerkki());
		}

		// haetaan ja tulostetaan kaikki kannassa olevat kirjaimella Salkavat entiteetit
		TypedQuery<String> kysely = manageri.createQuery(
				"SELECT tk.merkki FROM Tietokone AS tk where tk.merkki LIKE 'S%'",
				String.class);
		List<String> haetut = kysely.getResultList();
		for (String tulos : haetut) {
			System.out.println("S-alkuinen: " + tulos);
		}		

		manageri.close();
		tehdas.close();
	}
}