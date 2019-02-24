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


	public List<User> getAllUsers() {
		try {
			return userDao.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addUser(User user) throws IOException, UserShortLengthPasswordException, UserLoginAlreadyExistException, UserShortLengthLoginException {
		if (isUserByLoginExist(user.getLogin())) {
			throw new UserLoginAlreadyExistException();
		}
		if (userValidator.isValidate(user)) {
			userDao.saveUser(user);
			return true;
		}
		return false;
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

	@Override
	public void removeUserById(Long userId) throws IOException {
		userDao.removeUserById(userId);
	}

	@Override
	public User getUserByLogin(String login) {
		List<User> userList = getAllUsers();

		for (User user : userList) {
			if (user.getLogin().equalsIgnoreCase(login))
				return user;
		}
		return null;
	}

	@Override
	public User getUserById(Long userId) throws IOException {
		List<User> userList = getAllUsers();

		for (User user : userList) {
			if (user.getId().equals(userId))
				return user;
		}

		return null;
	}

	@Override
	public boolean isCorrectLoginAndPassword(String login, String password) {
		User foundUser = getUserByLogin(login);

		boolean isCorrectLogin = foundUser.getLogin().equals(login);
		boolean isCorrectPassword = foundUser.getPassword().equals(password);

		return isCorrectLogin && isCorrectPassword;
	}
}
