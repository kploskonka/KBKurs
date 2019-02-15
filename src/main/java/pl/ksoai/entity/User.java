package pl.ksoai.entity;

public class User {
	private Long id;
	private String login;
	private String password;
	public final static String USER_SEPARATOR = "#";

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public User(long id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
	}

	@Override
	public String toString() {
		return id + USER_SEPARATOR + login + USER_SEPARATOR + password;
	}
}
