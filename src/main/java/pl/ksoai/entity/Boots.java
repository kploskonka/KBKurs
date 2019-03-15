package pl.ksoai.entity;

import pl.ksoai.entity.enums.Color;
import pl.ksoai.entity.enums.ProductSeparators;
import pl.ksoai.entity.enums.SkinType;

public class Boots extends Product {
	private Integer size;

	public Integer getSize() {
		return size;
	}

	public Boots(Long id, String productName, Float price, Float weight, Color color, Integer productCount, Integer size, SkinType skinType) {
		super(id, productName, price, weight, color, productCount);
		this.size = size;
	}

	@Override
	public String toString() {
		return ProductSeparators.BOOTS_ID + ProductSeparators.PRODUCT_SEPARATOR.toString() + getBasicProductInfo() + ProductSeparators.PRODUCT_SEPARATOR.toString() + size + ProductSeparators.PRODUCT_SEPARATOR.toString() + isNaturalSkin;
	}
}
