package pl.ksoai.api;

import pl.ksoai.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

	void saveUser(User user) throws SQLException;
	void saveUsers(List<User> userList) throws SQLException;

	List<User> getAllUsers();

	void removeUserByLogin(String login) throws SQLException;
	void removeUserById(Long userId) throws SQLException;

	void updateUser(User user);
}
