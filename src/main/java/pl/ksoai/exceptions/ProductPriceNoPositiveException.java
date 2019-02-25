package pl.ksoai.exceptions;

public class ProductPriceNoPositiveException extends Exception {

	public ProductPriceNoPositiveException(String message) {
		super(message);
	}

	public ProductPriceNoPositiveException() {
		super("Product price is not positive.");
	}
}
