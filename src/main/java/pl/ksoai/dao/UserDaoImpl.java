package pl.ksoai.dao;

import pl.ksoai.api.UserDao;
import pl.ksoai.entity.User;
import pl.ksoai.entity.parser.UserParser;
import pl.ksoai.utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

	private static final String fileName = "users.data";
	private static UserDaoImpl instance = null;

	private UserDaoImpl() {
		try {
			FileUtils.createNewFile(fileName);
		} catch (IOException e) {
			System.out.println("Error with file path");
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public static UserDaoImpl getInstance() {
		if (instance == null) {
			instance = new UserDaoImpl();
		}

		return instance;
	}

	@Override
	public List<User> getAllUsers() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		List<User> userList = new ArrayList<>();

		String readLine = reader.readLine();
		while(readLine != null) {
			User user = UserParser.stringToUser(readLine);
			userList.add(user);
			readLine = reader.readLine();
		}

		reader.close();
		return userList;
	}

	@Override
	public void saveUsers(List<User> userList) throws IOException {
		FileUtils.clearFile(fileName);
		PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));

		for (User user : userList) {
			printWriter.write(user.toString());
		}

		printWriter.close();
	}

	@Override
	public void saveUser(User user) throws IOException {
		List<User> users = getAllUsers();
		users.add(user);
		saveUsers(users);
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

		saveUsers(userList);
	}
}
