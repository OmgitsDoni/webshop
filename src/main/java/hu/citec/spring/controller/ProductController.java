package hu.citec.spring.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.citec.spring.entities.Product;
import hu.citec.spring.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("/")
	public String products(Model model) {
		
		model.addAttribute("products", productService.findallProduct());
		
		return "product";
	}

	@GetMapping("/new")
	public String productCreator(Model model) {
		
		model.addAttribute("product", new Product());
		
		return "add_product";
	}
	
	@PostMapping("/new")
	public String createProduct(@ModelAttribute Product product) {
		
		productService.addProduct(product);
		
		return "redirect:/product/";
	}
	
	@GetMapping("/logout")
	public String logoutSession() {
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "redirect:/login";
	}
}