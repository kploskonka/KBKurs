package pl.ksoai.validator;

import pl.ksoai.entity.Product;
import pl.ksoai.exceptions.ProductCountNegativeException;
import pl.ksoai.exceptions.ProductNameEmptyException;
import pl.ksoai.exceptions.ProductPriceNoPositiveException;
import pl.ksoai.exceptions.ProductWeightNoPositiveException;

public class ProductValidator {
	private static ProductValidator instance = null;

	public static ProductValidator getInstance() {
		if (instance == null) {
			instance = new ProductValidator();
		}

		return instance;
	}

	private boolean isPricePositive(Float productPrice) {
		return productPrice > 0;
	}

	private boolean isProductCountPositive(Integer productCount) {
		return productCount >= 0;
	}

	private boolean isProductWeightPositive(Float productWeight) {
		return productWeight > 0;
	}

	private boolean isProductNameEmpty(String productName) {
		return productName == null || productName.isEmpty();
	}

	public boolean isValidate(Product product) throws ProductPriceNoPositiveException, ProductCountNegativeException, ProductWeightNoPositiveException, ProductNameEmptyException {
		if (!isPricePositive(product.getPrice())) {
			throw new ProductPriceNoPositiveException();
		}
		if (!isProductCountPositive(product.getProductCount())) {
			throw new ProductCountNegativeException();
		}
		if (!isProductWeightPositive(product.getWeight())) {
			throw new ProductWeightNoPositiveException();
		}
		if (isProductNameEmpty(product.getProductName())) {
			throw new ProductNameEmptyException();
		}
		return true;
	}
}
