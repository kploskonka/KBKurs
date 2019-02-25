package pl.ksoai.api;

import pl.ksoai.entity.User;

public interface UserLoginFacade {
	boolean registerUser(User user);
	boolean loginUser(String login, String password);
}
