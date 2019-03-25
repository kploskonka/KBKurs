package pl.ksoai.api;

import pl.ksoai.entity.User;
import pl.ksoai.exceptions.UserLoginAlreadyExistException;
import pl.ksoai.exceptions.UserShortLengthLoginException;
import pl.ksoai.exceptions.UserShortLengthPasswordException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserService {

	boolean addUser(User user) throws SQLException, UserShortLengthLoginException, UserShortLengthPasswordException, UserLoginAlreadyExistException;

	void removeUserById(Long userId) throws SQLException;

	List<User> getAllUsers();
	User getUserById(Long userId);
	User getUserByLogin(String login);

	boolean isCorrectLoginAndPassword(String login, String password);
}
