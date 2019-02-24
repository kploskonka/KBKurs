package pl.ksoai.exceptions;

public class ProductNameEmptyException extends Exception {
	public ProductNameEmptyException(String message) {
		super(message);
	}

	public ProductNameEmptyException() {
		super("Product name is empty.");
	}
}
