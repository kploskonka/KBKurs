package service;

import api.UserService;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

	List<User> users;

	public UserServiceImpl() {
		this.users = new ArrayList<User>();
	}

	public UserServiceImpl(List<User> users) {
		this.users = users;
	}

	public List<User> getAllUsers() {
		return users;
	}

	@Override
	public void addUser(User user) {
		users.add(user);
	}

	@Override
	public void removeUserById(Long userId) {
		for (int i = 0; i < users.size(); i++) {
			User userFromList = users.get(i);

			if (userFromList.getId() == userId) {
				users.remove(i);
				break;
			}
		}
	}


}
