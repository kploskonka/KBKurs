package pl.ksoai.entity;

public class Boots extends Product {
	private Integer size;
	private boolean isNaturalSkin;
	private static String PRODUCT_TYPE = "B";

	public Integer getSize() {
		return size;
	}

	public boolean isNaturalSkin() {
		return isNaturalSkin;
	}

	public Boots(Long id, String productName, Float price, Float weight, String color, Integer productCount, Integer size, Boolean isNaturalSkin) {
		super(id, productName, price, weight, color, productCount);
		this.size = size;
		this.isNaturalSkin = isNaturalSkin;
	}

	@Override
	public String toString() {
		return PRODUCT_TYPE + PRODUCT_SEPARATOR + getBasicProductInfo() + PRODUCT_SEPARATOR + size + PRODUCT_SEPARATOR + isNaturalSkin;
	}
}
