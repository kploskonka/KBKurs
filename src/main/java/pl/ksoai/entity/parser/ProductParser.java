package pl.ksoai.entity.parser;

import pl.ksoai.entity.Boots;
import pl.ksoai.entity.Cloth;
import pl.ksoai.entity.Product;

public class ProductParser {

	public static Product stringToProduct(String productStr) {
		final char productType = productStr.charAt(0);

		switch (productType) {
			case Product.PRODUCT_TYPE:
				return convertToProduct(productStr);
			case Cloth.PRODUCT_TYPE:
				return convertToCloth(productStr);
			case Boots.PRODUCT_TYPE:
				return convertToBoots(productStr);
			default:
				return null;
		}
	}

	private static Product convertToProduct(String productStr) {
		String [] productInformation = productStr.split(Product.PRODUCT_SEPARATOR);
		Long id = Long.parseLong(productInformation[1]);
		String productName = productInformation[2];
		Float price = Float.parseFloat(productInformation[3]);
		Float weight = Float.parseFloat(productInformation[4]);
		String color = productInformation[5];
		Integer productCount = Integer.parseInt(productInformation[6]);

		return new Product(id, productName, price, weight, color, productCount);
	}

	private static Cloth convertToCloth(String productStr) {
		String [] productInformation = productStr.split(Product.PRODUCT_SEPARATOR);
		Long id = Long.parseLong(productInformation[1]);
		String productName = productInformation[2];
		Float price = Float.parseFloat(productInformation[3]);
		Float weight = Float.parseFloat(productInformation[4]);
		String color = productInformation[5];
		Integer productCount = Integer.parseInt(productInformation[6]);
		String size = productInformation[7];
		String material = productInformation[8];

		return new Cloth(id, productName, price, weight, color, productCount, size, material);
	}

	private static Boots convertToBoots(String productStr) {
		String [] productInformation = productStr.split(Product.PRODUCT_SEPARATOR);
		Long id = Long.parseLong(productInformation[1]);
		String productName = productInformation[2];
		Float price = Float.parseFloat(productInformation[3]);
		Float weight = Float.parseFloat(productInformation[4]);
		String color = productInformation[5];
		Integer productCount = Integer.parseInt(productInformation[6]);
		Integer size = Integer.parseInt(productInformation[7]);
		Boolean isNaturalSkin = Boolean.getBoolean(productInformation[8]);

		return new Boots(id, productName, price, weight, color, productCount, size, isNaturalSkin);
	}
}
