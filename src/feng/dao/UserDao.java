package feng.dao;

import feng.domain.User;

public interface UserDao {
	public void add(User user);
	
	public User find(String name,String password);
}
