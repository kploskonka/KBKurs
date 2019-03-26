package pl.ksoai.api;

import pl.ksoai.entity.Product;
import pl.ksoai.exceptions.ProductCountNegativeException;
import pl.ksoai.exceptions.ProductNameEmptyException;
import pl.ksoai.exceptions.ProductPriceNoPositiveException;
import pl.ksoai.exceptions.ProductWeightNoPositiveException;

import java.io.IOException;
import java.util.List;

public interface ProductService {

	List<Product> getAllProducts() throws IOException;
	int countProducts() throws IOException;
	Product getProductByName(String productName) throws IOException;
	Product getProductById(Long productId) throws IOException;

	boolean doesProductExist(String productName) throws IOException;
	boolean doesProductExist(Long productId) throws IOException;
	boolean isAvailableOnWarehouse(String productName) throws IOException;

	boolean saveProduct(Product product) throws IOException, ProductCountNegativeException, ProductPriceNoPositiveException, ProductWeightNoPositiveException, ProductNameEmptyException;

	boolean removeProduct(String productName) throws Exception;
}
