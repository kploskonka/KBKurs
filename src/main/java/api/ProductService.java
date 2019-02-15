package api;

import entity.Product;

import java.util.List;

public interface ProductService {

	List<Product> getAllProducts();

	int countProducts();

	Product getProductByName(String productName);

	boolean doesProductExist(String productName);

	boolean doesProductExist(Long productId);

	boolean isAvailableOnWarehouse(String productName);
}
