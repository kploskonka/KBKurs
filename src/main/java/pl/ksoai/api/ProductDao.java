package pl.ksoai.api;

import pl.ksoai.entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductDao {

	void saveProduct(Product product) throws IOException;

	void saveProducts(List<Product> productList) throws IOException;

	void removeProductById(Long productId) throws IOException;

	boolean removeProductByName(String productName) throws IOException;

	List<Product> getAllProducts() throws IOException;
}
