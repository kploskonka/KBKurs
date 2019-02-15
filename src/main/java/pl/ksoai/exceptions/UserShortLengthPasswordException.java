package pl.ksoai.exceptions;

public class UserShortLengthPasswordException extends Exception {

	public UserShortLengthPasswordException() {
		super("User password too short");
	}

	public UserShortLengthPasswordException(String message) {
		super(message);
	}
}
