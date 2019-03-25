package pl.ksoai.api;

import pl.ksoai.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {

	void saveUser(User user);
	void saveUsers(List<User> userList) throws SQLException;

	List<User> getAllUsers();

	void removeUserByLogin(String login);
	void removeUserById(Long userId);

}
