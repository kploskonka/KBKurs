package pl.ksoai.exceptions;

public class ProductCountNegativeException extends Exception {
	public ProductCountNegativeException(String message) {
		super(message);
	}

	public ProductCountNegativeException() {
		super("Product count is negative.");
	}
}
