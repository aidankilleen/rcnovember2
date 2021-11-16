package ie.rc.SpringBootHelloWorld;

import java.util.List;

public interface UserDao {
	
	List<User> getUsers();
	User getUser(int id) throws UserDaoException;
	User addUser(User userToAdd);
	User updateUser(User userToUpdate);
	void deleteUser(int id) throws UserDaoException;

}
