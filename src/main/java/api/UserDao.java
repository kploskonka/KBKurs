package api;

import entity.User;

import java.util.List;

public interface UserDao {

	void saveUser();

	void saveUsers();

	List<User> getAllUsers();

	User getUserByLogin(String login);

	User getUserById(Long userId);

	void removeUserByLogin(String login);

	void removeUserById(Long userId);

}
