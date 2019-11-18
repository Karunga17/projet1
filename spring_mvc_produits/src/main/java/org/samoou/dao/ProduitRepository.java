package org.samoou.dao;

import java.util.List;

import org.samoou.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProduitRepository extends JpaRepository<Produit, Long>{
	public Page<Produit> findByDesignationContains(String motCle, Pageable pageable);
}