package pl.ksoai.api;

import pl.ksoai.entity.Product;

import java.util.List;

public interface ProductFacade {
	String createProduct(Product product);
	String removeProduct(String productName);
	List<Product> getAllProducts();
	Integer countProducts();
}
