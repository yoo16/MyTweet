package model;

public class Tweet {

	public Integer id;
	public Integer userId;
	public String message;
	public String postedAt;

	public void save(User user, String message)
	{
		this.userId = user.id;
		this.message = message;
	}

}
