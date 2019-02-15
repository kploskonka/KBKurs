package api;

import entity.Product;

import java.util.List;

public interface ProductService {

	List<Product> getAllProducts();

	int countProducts();

	Product getProductByName(String productName);

	boolean doesProductExistByName(String productName);

	boolean doesProductExistById(Long productId);

	boolean isAvailableOnWarehouse(String productName);
}
