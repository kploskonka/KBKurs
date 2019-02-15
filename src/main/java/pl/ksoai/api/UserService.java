package pl.ksoai.api;

import pl.ksoai.entity.User;
import pl.ksoai.exceptions.UserLoginAlreadyExistException;
import pl.ksoai.exceptions.UserShortLengthLoginException;
import pl.ksoai.exceptions.UserShortLengthPasswordException;

import java.io.IOException;
import java.util.List;

public interface UserService {

	List<User> getAllUsers() throws IOException;

	void addUser(User user) throws IOException, UserShortLengthPasswordException, UserLoginAlreadyExistException, UserShortLengthLoginException;

	void removeUserById(Long userId) throws IOException;
}
