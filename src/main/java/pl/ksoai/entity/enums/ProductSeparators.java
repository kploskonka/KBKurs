package pl.ksoai.entity.enums;

public enum ProductSeparators {
	PRODUCT_SEPARATOR("#"), PRODUCT_ID("P"), CLOTH_ID("C"), BOOTS_ID("B");

	private String productSeparator;

	ProductSeparators(String productSeparator) {
		this.productSeparator = productSeparator;
	}
}
