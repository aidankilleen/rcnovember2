package ie.rc.SpringBootHelloWorld;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqliteUserDao implements UserDao {

	private String url = "jdbc:sqlite:C:/data/rcnov2021/userdb.db";
	private Connection conn;

	public SqliteUserDao() {

		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User getUser(int id) throws UserDaoException {
		
		User user = null;
		
		String sql = "select * from users where id = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				//int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				boolean active = rs.getBoolean("active");
				
				user = new User(id, name, email, active);
				
			} else {
				throw new UserDaoException("User not found");
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	// List<User> getUsers()
	public List<User> getUsers() {

		List<User> users = new ArrayList<>();

		String sql = "select * from users";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				boolean active = rs.getBoolean("active");
				
				User u = new User(id, name, email, active);
				users.add(u);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	// User getUser(id)

	// User addUser(UserToAdd)
	   public User addUser(User newUser) {
	        try {

	            String sql = "insert into users (name, email, active) values(?, ?, ?)";

	            PreparedStatement stmt = conn.prepareStatement(sql);

	            stmt.setString(1, newUser.getName());
	            stmt.setString(2, newUser.getEmail());
	            stmt.setInt(3, newUser.isActive() ? 1 : 0);

	            stmt.executeUpdate();
	            stmt.close();

	            // read the newly created id
	            sql = "select last_insert_rowid();";
	            stmt = conn.prepareStatement(sql);

	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                int id = rs.getInt(1);
	                newUser.setId(id);
	            }
	            rs.close();

	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	        }
	        return newUser;

	    }

	// User updateUser(UserToUpdate)
	    public User updateUser(User userToUpdate) {

	        try {
	            String sql = "update users set name = ?, email = ?, active = ? where id = ?";

	            PreparedStatement stmt = conn.prepareStatement(sql);

	            stmt.setString(1, userToUpdate.getName());
	            stmt.setString(2, userToUpdate.getEmail());
	            stmt.setInt(3, userToUpdate.isActive() ? 1 : 0);
	            stmt.setInt(4, userToUpdate.getId());

	            stmt.executeUpdate();
	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	        }
	        return userToUpdate;
	    }
	// void deleteUser(id)
	    public void deleteUser(int id) throws UserDaoException {

	        PreparedStatement stmt = null;
	        try {
	            String sql = "delete from users where id = ?";
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, id);

	            int n = stmt.executeUpdate();

	            if (n == 0) {
	                throw new UserDaoException("No records deleted");
	            }

	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	        } finally {
	            System.out.println("finally called(deleteUser)");
	            try {
	                stmt.close();
	            } catch (SQLException throwables) {
	                throwables.printStackTrace();
	            }
	        }
	    }

}
