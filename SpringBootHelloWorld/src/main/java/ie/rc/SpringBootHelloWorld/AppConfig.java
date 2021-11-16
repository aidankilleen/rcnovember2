package ie.rc.SpringBootHelloWorld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public TestBean getTestBean() {
		return new TestBean();
	}
	
	@Bean("s1")
	public String getString1() {
		return "This is string 1";
	}
	
	@Bean("s2")
	public String getString2() {
		return "This is string 2";
	}
	
	
	public UserDao getDao() {
		
		//return new InMemoryUserDao();
		return new SqliteUserDao();
		
	}
}
