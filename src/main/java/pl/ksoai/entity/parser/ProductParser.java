package pl.ksoai.entity.parser;

import pl.ksoai.entity.Boots;
import pl.ksoai.entity.Cloth;
import pl.ksoai.entity.Product;
import pl.ksoai.entity.enums.Color;
import pl.ksoai.entity.enums.Material;
import pl.ksoai.entity.enums.ProductSeparators;
import pl.ksoai.entity.enums.SkinType;

public class ProductParser {

	public static Product stringToProduct(String productStr) {
		final ProductSeparators productId = ProductSeparators.getIdByChar(productStr.substring(0, 1));

		switch (productId) {
			case PRODUCT_ID:
				return convertToProduct(productStr);
			case CLOTH_ID:
				return convertToCloth(productStr);
			case BOOTS_ID:
				return convertToBoots(productStr);
			default:
				return null;
		}
	}

	private static Product convertToProduct(String productStr) {
		String [] productInformation = productStr.split(ProductSeparators.PRODUCT_SEPARATOR.toString());
		Long id = Long.parseLong(productInformation[1]);
		String productName = productInformation[2];
		Float price = Float.parseFloat(productInformation[3]);
		Float weight = Float.parseFloat(productInformation[4]);
		Color color = ColorParser.parseStringToColor(productInformation[5]);
		Integer productCount = Integer.parseInt(productInformation[6]);

		return new Product(id, productName, price, weight, color, productCount);
	}

	private static Cloth convertToCloth(String productStr) {
		String [] productInformation = productStr.split(ProductSeparators.PRODUCT_SEPARATOR.toString());
		Long id = Long.parseLong(productInformation[1]);
		String productName = productInformation[2];
		Float price = Float.parseFloat(productInformation[3]);
		Float weight = Float.parseFloat(productInformation[4]);
		Color color = ColorParser.parseStringToColor(productInformation[5]);
		Integer productCount = Integer.parseInt(productInformation[6]);
		String size = productInformation[7];
		Material material = MaterialParser.parseStringToMaterial(productInformation[8]);

		return new Cloth(id, productName, price, weight, color, productCount, size, material);
	}

	private static Boots convertToBoots(String productStr) {
		String [] productInformation = productStr.split(ProductSeparators.PRODUCT_SEPARATOR.toString());
		Long id = Long.parseLong(productInformation[1]);
		String productName = productInformation[2];
		Float price = Float.parseFloat(productInformation[3]);
		Float weight = Float.parseFloat(productInformation[4]);
		Color color = ColorParser.parseStringToColor(productInformation[5]);
		Integer productCount = Integer.parseInt(productInformation[6]);
		Integer size = Integer.parseInt(productInformation[7]);
		SkinType skinType = SkinParser.parseStringToSkin(productInformation[8]);

		return new Boots(id, productName, price, weight, color, productCount, size, skinType);
	}
}
