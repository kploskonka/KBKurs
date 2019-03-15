package pl.ksoai.entity;

import pl.ksoai.entity.enums.ProductSeparators;

public class Cloth extends Product {
	private String size;
	private String material;


	public String getMaterial() {
		return material;
	}

	public String getSize() {
		return size;
	}

	public Cloth(Long id, String productName, Float price, Float weight, String color, Integer productCount, String size, String material) {
		super(id, productName, price, weight, color, productCount);
		this.size = size;
		this.material = material;
	}

	@Override
	public String toString() {
		return ProductSeparators.CLOTH_ID.toString() + ProductSeparators.PRODUCT_SEPARATOR.toString() + getBasicProductInfo() + ProductSeparators.PRODUCT_SEPARATOR.toString() + size + ProductSeparators.PRODUCT_SEPARATOR.toString() + material;
	}
}
