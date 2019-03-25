package pl.ksoai.facade;

import pl.ksoai.api.UserLoginFacade;
import pl.ksoai.api.UserService;
import pl.ksoai.entity.User;
import pl.ksoai.service.UserServiceImpl;

public class UserLoginFacadeImpl implements UserLoginFacade {

	private UserService userService = UserServiceImpl.getInstance();
	private static UserLoginFacadeImpl instance = null;

	public static UserLoginFacadeImpl getInstance() {
		if (instance == null) {
			instance = new UserLoginFacadeImpl();
		}

		return instance;
	}

	@Override
	public boolean registerUser(User user) {
		try {
			return userService.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean loginUser(String login, String password) {
		return userService.isCorrectLoginAndPassword(login, password);
	}
}
