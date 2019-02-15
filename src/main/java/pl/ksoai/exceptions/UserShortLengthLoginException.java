package pl.ksoai.exceptions;

public class UserShortLengthLoginException extends Exception {

	public UserShortLengthLoginException() {
		super("User login too short");
	}

	public UserShortLengthLoginException(String message) {
		super(message);
	}
}
