package ie.rc.SpringBootJdbcTest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringBootJdbcTestApplication implements CommandLineRunner  {
	
	@Autowired
	private UserDao dao;
	
	
	Logger logger = LoggerFactory.getLogger(SpringBootJdbcTestApplication.class);
	
	
	@Value("${rc.authorname}")
	private String authorName;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Spring Boot JDBC");
		logger.info("By:" + authorName);
		
		//System.out.println("Spring Boot JDBC");
		//System.out.println("By:" + authorName);

		try {
			dao.getUser(999);
		} catch(Exception ex) {
			
		}
		/*
		for(User user:users) {
			
			System.out.println(user);
		}
	*/	
		
		
	}

}
