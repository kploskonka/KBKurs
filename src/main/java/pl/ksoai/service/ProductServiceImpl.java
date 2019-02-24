package pl.ksoai.service;

import pl.ksoai.api.ProductDao;
import pl.ksoai.api.ProductService;
import pl.ksoai.dao.ProductDaoImpl;
import pl.ksoai.entity.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {

	private static ProductServiceImpl instance = null;
	private ProductDao productDao = ProductDaoImpl.getInstance();

	private ProductServiceImpl() {}

	public ProductServiceImpl getInstance() {
		if (instance == null) {
			instance = new ProductServiceImpl();
		}

		return instance;
	}

	@Override
	public List<Product> getAllProducts() {
		try {
			return productDao.getAllProducts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int countProducts() {
		return getAllProducts().size();
	}

	@Override
	public Product getProductByName(String productName) {
		for (Product product : getAllProducts()) {
			if (product.getProductName().equalsIgnoreCase(productName)) return product;
		}
		return null;
	}

	@Override
	public Product getProductById(Long productId) {
		for (Product product : getAllProducts()) {
			if (product.getId().equals(productId)) return product;
		}
		return null;
	}

	@Override
	public boolean doesProductExist(String productName) {
		Product product = getProductByName(productName);

		return product == null;
	}

	@Override
	public boolean doesProductExist(Long productId) {
		Product product = getProductById(productId);

		return product == null;
	}

	@Override
	public boolean isAvailableOnWarehouse(String productName) {
		for (Product product : getAllProducts()) {
			if (doesProductExist(productName) && product.getProductCount() > 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean saveProduct(Product product) {
		return false;
	}
}
