package pl.ksoai.service;

import pl.ksoai.api.ProductDao;
import pl.ksoai.api.ProductService;
import pl.ksoai.dao.ProductDaoImpl;
import pl.ksoai.entity.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

	private static ProductServiceImpl instance = null;
	private ProductDao productDao = new ProductDaoImpl("products.data", "PRODUCT");

	private ProductServiceImpl() {}

	public ProductServiceImpl getInstance() {
		if (instance == null) {
			instance = new ProductServiceImpl();
		}

		return instance;
	}

	@Override
	public List<Product> getAllProducts() throws IOException {
		return productDao.getAllProducts();
	}

	@Override
	public int countProducts() throws IOException {
		return getAllProducts().size();
	}

	@Override
	public Product getProductByName(String productName) throws IOException {
		for (Product product : getAllProducts()) {
			if (product.getProductName().equalsIgnoreCase(productName)) return product;
		}
		return null;
	}

	@Override
	public boolean doesProductExist(String productName) {
		Product product = null;

		try {
			product = productDao.getProductByName(productName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (product == null) return false;

		return true;
	}

	@Override
	public boolean doesProductExist(Long productId) {
		Product product = null;

		try {
			product = productDao.getProductById(productId);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (product == null) return false;

		return true;
	}

	@Override
	public boolean isAvailableOnWarehouse(String productName) throws IOException {
		try {
			for(Product product : getAllProducts()) {
				if (doesProductExist(productName) && product.getProductCount() > 0) {
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
