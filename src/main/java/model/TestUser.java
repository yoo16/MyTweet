package model;

public class TestUser {
	
	public static User getOne()
	{
		User user = new User();
		user.id = 1;
		user.name = "Alice";
		user.email = "alice@test.com";
		user.password = "pass1234";
		return user;
	}
}
