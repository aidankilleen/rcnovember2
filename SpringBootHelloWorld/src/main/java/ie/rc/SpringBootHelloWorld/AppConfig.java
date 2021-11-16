package ie.rc.SpringBootHelloWorld;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.sqlite.SQLiteDataSource;

@Configuration
public class AppConfig {

	@Value("${jdbcurl}")
	private String jdbcurl;
	
	
	@Bean
	public DataSource getDatasource() {
		
		SQLiteDataSource ds = new SQLiteDataSource();
		//ds.setUrl("jdbc:sqlite:C:/data/rcnov2021/userdb.db");
		System.out.println("url:" + jdbcurl);
		ds.setUrl(jdbcurl);
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDatasource());
		return jdbcTemplate;
	}
	
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
