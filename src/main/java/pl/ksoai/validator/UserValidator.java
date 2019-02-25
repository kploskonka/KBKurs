package pl.ksoai.validator;

import pl.ksoai.entity.User;
import pl.ksoai.exceptions.UserShortLengthLoginException;
import pl.ksoai.exceptions.UserShortLengthPasswordException;


public class UserValidator {

	private static UserValidator instance = null;

	private final int MIN_PASSWORD_LENGTH = 6;
	private final int MIN_LOGIN_LENGTH = 4;

	private UserValidator() {}

	public boolean isValidate(User user) throws UserShortLengthLoginException, UserShortLengthPasswordException {

		if (!isLoginLongEnough(user.getLogin())) {
			throw new UserShortLengthLoginException("Login should be at least 4 characters long.");
		}
		if (!isPasswordLongEnough(user.getPassword())) {
			throw new UserShortLengthPasswordException("Password should be at least 6 characters long.");
		}
		return true;
	}


	private boolean isPasswordLongEnough(String userPassword) {
		return userPassword.length() >= MIN_PASSWORD_LENGTH;
	}

	private boolean isLoginLongEnough(String userLogin) {
		return userLogin.length() >= MIN_LOGIN_LENGTH;
	}

	public static UserValidator getInstance() {
		if (instance == null) {
			instance = new UserValidator();
		}

		return instance;
	}
}
