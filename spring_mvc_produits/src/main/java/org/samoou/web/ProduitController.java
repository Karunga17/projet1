package org.samoou.web;

import java.util.List;

import javax.validation.Valid;

import org.samoou.dao.ProduitRepository;
import org.samoou.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository produitRepository;
	
//	@RequestMapping(value = "/index", method = RequestMethod.GET )
	@GetMapping("/user/index") 
	public String index(Model model,
			@RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="motCle", defaultValue = "") String motCle) {
//		Page<Produit> pageProduits = produitRepository.findAll(PageRequest.of(page, 5));
		Page<Produit> pageProduits = 
				produitRepository.findByDesignationContains(motCle, PageRequest.of(page, 5));
		model.addAttribute("produits", pageProduits.getContent());
		model.addAttribute("pages", new int[pageProduits.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", motCle);
		return "produits";
	}
	
	@GetMapping("/admin/delete")
	public String delete(Model model, 
			@RequestParam(name="id") Long id,
			@RequestParam(name="page") int page ,
			@RequestParam(name="motCle") String motCle) {
		produitRepository.deleteById(id);
		return "redirect:/user/index?page="+page+"&motCle="+motCle;
	}
	
	@GetMapping("/admin/edit")
	public String edit(Model model, Long id) { 
		Produit produit = produitRepository.findById(id).get();
		model.addAttribute("produit", produit);
		return "editProduit";
	}
	
	@GetMapping("/admin/formProduit")
	public String form(Model model) {
		model.addAttribute("produit", new Produit());
		return "formProduit";
	}
	
	@PostMapping("/admin/save") 
	public String save(Model model, @Valid Produit produit, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) return "formProduit";
		produitRepository.save(produit);
		return "redirect:/user/index";
	}
	
	@GetMapping("/")
	public String def() { 

		return "redirect:/user/index";
	}
	
}
