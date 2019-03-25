package pl.ksoai.facade;

import pl.ksoai.api.ProductFacade;
import pl.ksoai.api.ProductService;
import pl.ksoai.entity.Product;
import pl.ksoai.service.ProductServiceImpl;

import java.util.List;

public class ProductFacadeImpl implements ProductFacade {

	private ProductService productService = ProductServiceImpl.getInstance();
	private static ProductFacadeImpl instance = null;

	public static ProductFacadeImpl getInstance() {
		if (instance == null) {
			instance = new ProductFacadeImpl();
		}

		return instance;
	}

	@Override
	public String createProduct(Product product) {
		try {
			productService.saveProduct(product);
			return "Product successfully saved!";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	@Override
	public String removeProduct(String productName) {
		try {
			List<Product> products = productService.getAllProducts();

			for (Product product : products) {
				if (product.getProductName().equalsIgnoreCase(productName)) {
					products.remove(product);
					return "Product successfully removed!";
				}
			}

			return "Given product does not exist";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	@Override
	public List<Product> getAllProducts() {
		try {
			return productService.getAllProducts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
