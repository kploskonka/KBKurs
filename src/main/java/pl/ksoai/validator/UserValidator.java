package pl.ksoai.validator;

import pl.ksoai.api.UserDao;
import pl.ksoai.dao.UserDaoImpl;
import pl.ksoai.entity.User;
import pl.ksoai.exceptions.UserLoginAlreadyExistException;
import pl.ksoai.exceptions.UserShortLengthLoginException;
import pl.ksoai.exceptions.UserShortLengthPasswordException;

import java.io.IOException;
import java.util.List;

public class UserValidator {

	private static UserValidator instance = null;
	private UserDao userDao = UserDaoImpl.getInstance();

	private UserValidator() {}

	public boolean isValidate(User user) throws UserShortLengthLoginException, UserShortLengthPasswordException, UserLoginAlreadyExistException {

		if (isUserByLoginExist(user.getLogin())) {
			throw new UserLoginAlreadyExistException("User with this login already exists.");
		}
		if (user.getLogin().length() < 4) {
			throw new UserShortLengthLoginException("Login should be at least 4 characters long.");
		}
		if (user.getPassword().length() < 6) {
			throw new UserShortLengthPasswordException("Password should be at least 6 characters long.");
		}
		return true;
	}

	private boolean isUserByLoginExist(String userLogin) {
		try {
			List<User> userList = userDao.getAllUsers();
			for (User user : userList) {
				if (user.getLogin().equalsIgnoreCase(userLogin)) {
					return true;
				}
			}

			return false;
		} catch (IOException e) {
			System.out.println("User list is empty");
			return false;
		}
	}

	public static UserValidator getInstance() {
		if (instance == null) {
			instance = new UserValidator();
		}

		return instance;
	}
}
