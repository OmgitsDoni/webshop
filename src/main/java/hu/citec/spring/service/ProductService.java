package hu.citec.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.citec.spring.entities.Product;
import hu.citec.spring.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	public ProductService(ProductRepository repo) {
		this.repo = repo;
	}
	
	public void addProduct(Product product) {
		repo.addProduct(product);
	}
	
	public List<Product> findallProduct() {
		return repo.findAllProduct();
	}
	
	public boolean findUser(String username) {
		return repo.findUser(username);
	}
}