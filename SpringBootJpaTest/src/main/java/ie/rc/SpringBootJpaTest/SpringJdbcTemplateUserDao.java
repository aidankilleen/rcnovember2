package ie.rc.SpringBootJpaTest;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.sqlite.SQLiteDataSource;


public class SpringJdbcTemplateUserDao implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	Logger logger = LoggerFactory.getLogger(SpringJdbcTemplateUserDao.class);
	
	public SpringJdbcTemplateUserDao() {
		
		logger.info("JDBC Template User Dao Created");
		//ds = new SQLiteDataSource();
		//ds.setUrl("jdbc:sqlite:C:/data/rcnov2021/userdb.db");
		
		//jdbcTemplate = new JdbcTemplate(ds);
	}

	@Override
	public List<User> getUsers() {
		
		List<User> users = jdbcTemplate.query(
				"select * from users", new UserRowMapper());
		return users;
	}

	@Override
	public User getUser(int id) throws UserDaoException {
	
		try {
			User user = jdbcTemplate.queryForObject(
					"select * from users where id = ?",
					new UserRowMapper(), id);
			return user;
		} catch (Exception ex) {
			logger.error("Can't find user " + id);
			throw new UserDaoException("User not found");
		}
	}

	@Override
	public User addUser(User userToAdd) {
		jdbcTemplate.update("insert into users (name, email, active) values(?, ?, ?)", 
				userToAdd.getName(), 
				userToAdd.getEmail(), 
				userToAdd.isActive());
		
		// TODO - get the id of the new user
		return userToAdd;
	}

	@Override
	public User updateUser(User userToUpdate) {
	
		jdbcTemplate.update("update users set name=?, email=?, active=? where id=?", 
				userToUpdate.getName(), 
				userToUpdate.getEmail(), 
				userToUpdate.isActive(), 
				userToUpdate.getId());
		
		return userToUpdate;
	}

	@Override
	public void deleteUser(int id) throws UserDaoException {
		
		if (jdbcTemplate.update("delete from users where id=?", id) == 0) {
			throw new UserDaoException("no user deleted");
		}
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
