package pl.ksoai.api;

import pl.ksoai.entity.User;
import pl.ksoai.exceptions.UserLoginAlreadyExistException;
import pl.ksoai.exceptions.UserShortLengthLoginException;
import pl.ksoai.exceptions.UserShortLengthPasswordException;

import java.io.IOException;
import java.util.List;

public interface UserService {

	boolean addUser(User user);

	void removeUserById(Long userId) throws IOException;

	List<User> getAllUsers();
	User getUserById(Long userId) throws IOException;
	User getUserByLogin(String login);

	boolean isCorrectLoginAndPassword(String login, String password);
}
