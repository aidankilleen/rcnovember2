package ie.rc.SpringHelloWorld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotatedSpringApp {

	public static void main(String[] args) {
		
		
		System.out.println("Annotated Spring App");
		
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		TestBean tb = ctx.getBean(TestBean.class);
		
		System.out.println(tb);
		
		
		String s = (String)ctx.getBean("s1");
		
		System.out.println(s);
		

		s = (String)ctx.getBean("s2");
		
		System.out.println(s);
		
		
		

	}

}
