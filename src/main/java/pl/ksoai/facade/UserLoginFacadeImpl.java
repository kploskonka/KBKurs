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
		return userService.addUser(user);
	}

	@Override
	public boolean loginUser(String login, String password) {
		return userService.isCorrectLoginAndPassword(login, password);
	}
}
