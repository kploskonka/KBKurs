package pl.ksoai.service;

import pl.ksoai.api.ProductService;
import pl.ksoai.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

	private List<Product> products;

	public ProductServiceImpl() {
		this.products = new ArrayList<Product>();
	}

	public ProductServiceImpl(List<Product> products) {
		this.products = products;
	}

	@Override
	public List<Product> getAllProducts() {
		return products;
	}

	@Override
	public int countProducts() {
		return products.size();
	}

	@Override
	public Product getProductByName(String productName) {
		for (Product product : products) {
			if (product.getProductName().equalsIgnoreCase(productName)) return product;
		}
		return null;
	}

	@Override
	public boolean doesProductExist(String productName) {
		for (Product product : products) {
			if (product.getProductName().equalsIgnoreCase(productName)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean doesProductExist(Long productId) {
		for (Product product : products) {
			if (product.getId().equals(productId)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isAvailableOnWarehouse(String productName) {
		if (doesProductExist(productName)) {
			if (getProductByName(productName).getProductCount() > 0) { return true;}
		}

		return false;
	}
}
