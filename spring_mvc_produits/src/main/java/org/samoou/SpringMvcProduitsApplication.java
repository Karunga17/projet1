package org.samoou;

import org.samoou.dao.ProduitRepository;
import org.samoou.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcProduitsApplication implements CommandLineRunner {
	@Autowired
	private ProduitRepository produitRepository;

	public static void main(String[] args) {
		// Spring va démarer
		SpringApplication.run(SpringMvcProduitsApplication.class, args);
	}

	// une fois spring terminer le démarage complet il fait appel  a la méthode run
	@Override
	public void run(String... args) throws Exception {

//		produitRepository.save(new Produit("HP", 6000, 12));
//		produitRepository.save(new Produit("Sumsung", 1000, 2));
//		produitRepository.save(new Produit("Lenovo", 3000, 10));
//		produitRepository.save(new Produit("DELL", 6400, 14));
//		produitRepository.save(new Produit("HP", 6000, 12));
//		produitRepository.save(new Produit("Sumsung", 1000, 2));
//		produitRepository.save(new Produit("Lenovo", 3000, 10));
//		produitRepository.save(new Produit("DELL", 6400, 14));
//		produitRepository.save(new Produit("HP", 6000, 12));
//		produitRepository.save(new Produit("Sumsung", 1000, 2));
//		produitRepository.save(new Produit("Lenovo", 3000, 10));
//		produitRepository.save(new Produit("DELL", 6400, 14));
//		produitRepository.save(new Produit("HP", 6000, 12));
//		produitRepository.save(new Produit("Sumsung", 1000, 2));
//		produitRepository.save(new Produit("Lenovo", 3000, 10));
//		produitRepository.save(new Produit("DELL", 6400, 14));
		produitRepository.findAll().forEach(p -> {
			System.out.println(p.getDesignation());
		});;
	}

}
