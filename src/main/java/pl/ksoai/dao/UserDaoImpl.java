package pl.ksoai.dao;

import pl.ksoai.api.UserDao;
import pl.ksoai.entity.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao {

	private Connection connection;
	private final String databaseName = "management";
	private final String tableName = "users";
	private final String user = "root";
	private final String password = "admin";
	private static UserDaoImpl instance = null;

	private UserDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?serverTimezone=UTC", user, password);
		} catch (Exception e) {
			System.out.println("Error with database connection");
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
	public List<User> getAllUsers() {

		List<User> userList = new LinkedList<User>();

		try (Statement statement = connection.createStatement()) {
			String query = "select * from " + tableName;
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String login = resultSet.getString("login");
				String password = resultSet.getString("password");

				User user = new User(id, login, password);
				userList.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}

	@Override
	public void saveUsers(List<User> userList) throws SQLException {
		PreparedStatement preparedStatement = null;

		try {
			for (User user : userList) {
				String query = "insert into " + tableName + " (id, login, password) values(?, ?, ?)";
				preparedStatement = connection.prepareStatement(query);

				preparedStatement.setLong(1, user.getId());
				preparedStatement.setString(2, user.getLogin());
				preparedStatement.setString(3, user.getPassword());

				preparedStatement.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}
	}

	@Override
	public void saveUser(User user) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			String query = "insert into " + tableName + " (login, password) values(?, ?)";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}
	}

	@Override
	public void removeUserById(Long userId) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			String query = "delete from " + tableName + " where id=?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}
	}

	@Override
	public void removeUserByLogin(String login) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			String query = "delete from " + tableName + " where login=?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, login);
			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}
	}

	public void updateUser(User user) {
		PreparedStatement statement;
		try {
			String query = "update " + tableName + " set login = ?, password = ? where id=?";
			statement = connection.prepareStatement(query);
			statement.setString(1, user.getLogin());
			statement.setString(2, user.getPassword());
			statement.setLong(3, user.getId());
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
