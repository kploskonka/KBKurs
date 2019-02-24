package pl.ksoai.exceptions;

public class ProductWeightNoPositiveException extends Exception {

	public ProductWeightNoPositiveException(String message) {
		super(message);
	}

	public ProductWeightNoPositiveException() {
		super("Product weight is not positive.");
	}
}
