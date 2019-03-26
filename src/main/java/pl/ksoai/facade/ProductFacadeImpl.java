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
			if (productService.saveProduct(product)) {
				return "Product successfully saved!";
			} else {
				return "Product not saved";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	@Override
	public String removeProduct(String productName) {
		try {
			if (productService.removeProduct(productName)) {
				return "Product removed successfully";
			} else {
				return "Product does not exist";
			}
		} catch (Exception e) {
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

	@Override
	public Integer countProducts() {
		try {
			return productService.countProducts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
