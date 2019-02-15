package pl.ksoai.dao;

import pl.ksoai.api.UserDao;
import pl.ksoai.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

	private final String fileName;

	public UserDaoImpl(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public List<User> getAllUsers() throws IOException {
		FileReader fileReader = new FileReader(fileName);
		BufferedReader reader = new BufferedReader(fileReader);
		List<User> userList = new ArrayList<User>();

		String readLine = reader.readLine();
		while(readLine != null) {
			String [] values = readLine.split("#");
			User user = new User(Long.parseLong(values[0]), values[1], values[2]);
			userList.add(user);
		}

		reader.close();
		return userList;
	}

	@Override
	public void saveUser(User user) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
		PrintWriter printWriter = new PrintWriter(fileOutputStream);

		printWriter.write(user.toString());
		printWriter.close();
	}

	@Override
	public void saveUsers(List<User> userList) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
		PrintWriter printWriter = new PrintWriter(fileOutputStream);

		for (User user : userList) {
			printWriter.write(user.toString());
		}

		printWriter.close();
	}

	@Override
	public User getUserByLogin(String login) throws IOException {
		List<User> userList = getAllUsers();

		for (User user : userList) {
			if (user.getLogin().equalsIgnoreCase(login))
				return user;
		}
		return null;
	}

	@Override
	public User getUserById(Long userId) throws IOException {
		List<User> userList = getAllUsers();

		for (User user : userList) {
			if (user.getId().equals(userId))
				return user;
		}

		return null;
	}

	@Override
	public void removeUserById(Long userId) throws IOException {
		List<User> userList = getAllUsers();

		for (User user : userList) {
			if (user.getId().equals(userId)) {
				userList.remove(user);
				break;
			}
		}

		PrintWriter writer = new PrintWriter(fileName);
		writer.print("");
		writer.close();

		saveUsers(userList);
	}

	@Override
	public void removeUserByLogin(String login) throws IOException {
		List<User> userList = getAllUsers();

		for (User user : userList) {
			if (user.getLogin().equalsIgnoreCase(login)) {
				userList.remove(user);
				break;
			}
		}

		PrintWriter writer = new PrintWriter(fileName);
		writer.print("");
		writer.close();

		saveUsers(userList);
	}
}
