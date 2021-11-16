package ie.rc.SpringBootJpaTest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class JpaUserDao implements UserDao {
	
	
	@Autowired
	private UserRepository repo;
	

	@Override
	public List<User> getUsers() {
		List<User> users = repo.findAll();
		return users;
	}

	@Override
	public User getUser(int id) throws UserDaoException {
		
		Optional<User> user = repo.findById(id);
		
		if (user.isPresent()) {
			return user.get();
		}
		throw new UserDaoException("User not found");
	}

	@Override
	public User addUser(User userToAdd) {
		
		repo.save(userToAdd);
		return userToAdd;
	}

	@Override
	public User updateUser(User userToUpdate) {

		repo.save(userToUpdate);
		return userToUpdate;
	}

	@Override
	public void deleteUser(int id) throws UserDaoException {
		try {
			repo.deleteById(id);
		} catch (Exception ex) {
			throw new UserDaoException("User not found");
		}
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
