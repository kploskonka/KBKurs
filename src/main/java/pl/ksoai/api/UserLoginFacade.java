package pl.ksoai.api;

import pl.ksoai.entity.User;

public interface UserLoginFacade {
	String registerUser(User user);
	boolean loginUser(String login, String password);
}
