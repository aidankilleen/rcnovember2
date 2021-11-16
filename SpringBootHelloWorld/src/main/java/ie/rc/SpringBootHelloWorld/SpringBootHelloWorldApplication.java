package ie.rc.SpringBootHelloWorld;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootHelloWorldApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		userService.doSomethingWithUsers();
		
		
		/*
		 * Dependency Injection ONLY works on Spring-managed beans
		 */
		//UserService us = new UserService();
		
		//us.doSomethingWithUsers();
		
		
		
		
		
		// Without dependency injection / Inversion of Control
		// create a datasource
		//DataSource ds = new SQLiteDataSource();
		//ds.seUrl(url);
		
		// create a jdbctemplate
		//JdbcTemplate jdbc = new JdbcTemplate(ds;)
		
		// create a UserDao
		//UserDao dao = new SqliteUserDao(jdbc);
		
		// create a UserService
		//UserService userService = new UserService(dao)
		
		
		// do something with the service
		//userService.doSomethingWithUsers();
		
		
		
		
		
		/*
		System.out.println("Database test...");
		
		// dao.deleteUser(7);
		User newUser = new User("NEW", "new.user@gmail.com", false);
		
		dao.addUser(newUser);
		
		User u4 = dao.getUser(4);
		
		u4.setName("CHANGED");
		u4.setEmail("changed@gmail.com");
		u4.setActive(!u4.isActive());
		dao.updateUser(u4);
		
		
		
		List<User> users = dao.getUsers();
		
		for (User u: users) {
			
			System.out.println(u);
			
		}
				
		*/
		
		// no need to instantiate dao - it will be autowired
		//SqliteUserDao dao = new SqliteUserDao();
		
		//User newUser = new User("NEW", "new.user@gamil.com", true);
		//User addedUser = dao.addUser(newUser);
		
		
		//System.out.println(addedUser);
		
		
		/*
		
		User u1 = dao.getUser(1);
		
		
		u1.setName("CHANGED");
		u1.setEmail("changed@gmail.com");
		u1.setActive(u1.isActive());
		
		dao.updateUser(u1);
		
		
		//System.out.println(u1);
		
		
		dao.deleteUser(1);
		*/
		

		
		/*
		String url = "jdbc:sqlite:C:/data/rcnov2021/userdb.db";
		Connection conn = DriverManager.getConnection(url);
		
		String sql = "select * from users";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next() ) {
			
			System.out.println(rs.getString("name"));
		}
		
		rs.close();
		stmt.close();
		conn.close();
		*/
		
		
	}
}
