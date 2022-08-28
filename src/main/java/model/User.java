package model;

public class User {

	public Integer id;
	public String email;
	public String name;
	public String password;

	public User auth(String email, String password)
	{
		User user = TestUser.getOne();
		if (email.equals(user.email) && password.equals(user.password)) {
			return user;
		}
		return null;
	}
}
