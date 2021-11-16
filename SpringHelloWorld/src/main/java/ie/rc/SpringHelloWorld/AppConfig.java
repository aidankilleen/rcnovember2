package ie.rc.SpringHelloWorld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	
	@Bean
	public TestBean getTestBean() {
		
		TestBean tb = new TestBean();
		return tb;
	}
	
	@Bean("s1")
	public String getString1() {
		
		return new String("String 1");
	}
	
	@Bean("s2")
	public String getString2() {
		
		return new String("String 2");
	}

}
