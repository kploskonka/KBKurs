package pl.ksoai.api;

import pl.ksoai.entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {

	List<Product> getAllProducts() throws IOException;

	int countProducts() throws IOException;

	Product getProductByName(String productName) throws IOException;

	boolean doesProductExist(String productName);

	boolean doesProductExist(Long productId);

	boolean isAvailableOnWarehouse(String productName) throws IOException;
}
