package ie.rc.SpringHelloWorld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Spring Framework Test");
        
        TestBean tb = new TestBean();
        
        System.out.println(tb);
        
        // Inversion of Control
        
        // request a TestBean object from the framework
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        
        TestBean tb2 = ctx.getBean(TestBean.class);
        
        System.out.println(tb2);
        
        
        
        String s = (String)ctx.getBean("s1");
        
        System.out.println(s);
        
        
        String s2 = (String)ctx.getBean("s2");
        
        System.out.println(s2);
        
        		
        
        
        
    }
}
