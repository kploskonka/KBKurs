package pl.ksoai.service;

import pl.ksoai.api.UserDao;
import pl.ksoai.api.UserService;
import pl.ksoai.dao.UserDaoImpl;
import pl.ksoai.entity.User;
import pl.ksoai.exceptions.UserLoginAlreadyExistException;
import pl.ksoai.exceptions.UserShortLengthLoginException;
import pl.ksoai.exceptions.UserShortLengthPasswordException;
import pl.ksoai.validator.UserValidator;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService {

	private static UserServiceImpl instance = null;
	private UserDao userDao = UserDaoImpl.getInstance();
	private UserValidator userValidator = UserValidator.getInstance();

	private UserServiceImpl() { }

	public static UserServiceImpl getInstance() {
		if (instance == null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}


	public List<User> getAllUsers() throws IOException {
		return userDao.getAllUsers();
	}

	@Override
	public void addUser(User user) throws IOException, UserShortLengthPasswordException, UserLoginAlreadyExistException, UserShortLengthLoginException {
		if (userValidator.isValidate(user)) {
			userDao.saveUser(user);
		}
	}

	@Override
	public void removeUserById(Long userId) throws IOException {
		userDao.removeUserById(userId);
	}
}
