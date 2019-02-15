package pl.ksoai.exceptions;

public class UserLoginAlreadyExistException extends Exception {

	public UserLoginAlreadyExistException(String message) {
		super(message);
	}

	public UserLoginAlreadyExistException() {
		super("User login not found");
	}
}
