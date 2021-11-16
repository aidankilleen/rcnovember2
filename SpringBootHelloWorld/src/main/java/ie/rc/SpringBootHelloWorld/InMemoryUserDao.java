package ie.rc.SpringBootHelloWorld;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserDao implements UserDao {

	private List<User> users = new ArrayList<>();
	
	public InMemoryUserDao() {
		
		users.add(new User(1, "Zoltar", "zoltar@gmail.com", true));
		users.add(new User(2, "Yvonne", "yvonne@gmail.com", false));
		users.add(new User(3, "Xavier", "xavier@gmail.com", true));
		users.add(new User(4, "Wendy", "wendy@gmail.com", false));
		users.add(new User(5, "Veronica", "veronica@gmail.com", true));
		
	}
	
	@Override
	public List<User> getUsers() {
		
		return users;
	}
	

	@Override
	public User getUser(int id) throws UserDaoException {
		
		int index = findIndex(id);
        return users.get(index);
	}
    public int findIndex(int id) throws UserDaoException {
        for (int i=0; i<users.size(); i++) {
            if (users.get(i).getId() == id) {
                return i;
            }
        }
        throw new UserDaoException("Id not found");
    }

    @Override
    public User addUser(User newUser) {

        // assign unique id
        int maxId = users.stream()
                .mapToInt(u->u.getId())
                .max()
                .getAsInt();

        newUser.setId(maxId + 1);

        users.add(newUser);
        return newUser;
    }
    
    @Override
    public User updateUser(User userToUpdate) {

        try {
            int index = findIndex(userToUpdate.getId());

            users.set(index, userToUpdate);

        } catch (UserDaoException e) {

        }

        return userToUpdate;
    }
    
    @Override
    public void deleteUser(int id) throws UserDaoException {

        int index = findIndex(id);
        users.remove(index);
    }
}
