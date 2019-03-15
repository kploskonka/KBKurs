package pl.ksoai.entity.enums;

import pl.ksoai.entity.Product;

public enum ProductSeparators {
	PRODUCT_SEPARATOR("#"), PRODUCT_ID("P"), CLOTH_ID("C"), BOOTS_ID("B");

	private String productSeparator;

	ProductSeparators(String productSeparator) {
		this.productSeparator = productSeparator;
	}

	@Override
	public String toString() {
		return productSeparator;
	}

	public String getProductSeparator() {
		return productSeparator;
	}

	public static ProductSeparators getIdByChar(String productSeparator) {
		for (ProductSeparators id : ProductSeparators.values()) {
			if (id.getProductSeparator().equals(productSeparator)) {
				return id;
			}
		}
		return null;
	}
}
