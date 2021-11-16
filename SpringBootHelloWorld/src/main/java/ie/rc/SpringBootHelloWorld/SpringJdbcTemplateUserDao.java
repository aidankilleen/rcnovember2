package ie.rc.SpringBootHelloWorld;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.sqlite.SQLiteDataSource;

@Component
public class SpringJdbcTemplateUserDao implements UserDao {
	
	private SQLiteDataSource ds;
	private JdbcTemplate jdbcTemplate;
	
	public SpringJdbcTemplateUserDao() {
		
		ds = new SQLiteDataSource();
		ds.setUrl("jdbc:sqlite:C:/data/rcnov2021/userdb.db");
		
		jdbcTemplate = new JdbcTemplate(ds);
	}

	@Override
	public List<User> getUsers() {
		
		List<User> users = jdbcTemplate.query("select * from users", new UserRowMapper());
		
		return users;
	}

	@Override
	public User getUser(int id) throws UserDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUser(User userToAdd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User userToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int id) throws UserDaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
