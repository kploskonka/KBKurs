package pl.ksoai.service;

import pl.ksoai.api.ProductDao;
import pl.ksoai.api.ProductService;
import pl.ksoai.dao.ProductDaoImpl;
import pl.ksoai.entity.Product;
import pl.ksoai.exceptions.ProductCountNegativeException;
import pl.ksoai.exceptions.ProductNameEmptyException;
import pl.ksoai.exceptions.ProductPriceNoPositiveException;
import pl.ksoai.exceptions.ProductWeightNoPositiveException;
import pl.ksoai.validator.ProductValidator;

import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

	private static ProductServiceImpl instance = null;
	private ProductDao productDao = ProductDaoImpl.getInstance();
	private ProductValidator productValidator = ProductValidator.getInstance();

	private ProductServiceImpl() {}

	public static ProductServiceImpl getInstance() {
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
	public Product getProductById(Long productId) throws IOException {
		for (Product product : getAllProducts()) {
			if (product.getId().equals(productId)) return product;
		}
		return null;
	}

	@Override
	public boolean doesProductExist(String productName) throws IOException {
		Product product = getProductByName(productName);

		return product == null;
	}

	@Override
	public boolean doesProductExist(Long productId) throws IOException {
		Product product = getProductById(productId);

		return product == null;
	}

	@Override
	public boolean isAvailableOnWarehouse(String productName) throws IOException {
		for (Product product : getAllProducts()) {
			if (doesProductExist(productName) && product.getProductCount() > 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean saveProduct(Product product) throws IOException, ProductCountNegativeException, ProductPriceNoPositiveException, ProductWeightNoPositiveException, ProductNameEmptyException {
		if (productValidator.isValidate(product)) {
			productDao.saveProduct(product);
			return true;
		}

		return false;
	}
}
