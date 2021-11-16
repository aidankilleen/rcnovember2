package ie.rc.SpringBootHelloWorld;

import org.springframework.stereotype.Component;


public class TestBean {

	private String message = "Default Message";

	public TestBean(String message) {
		super();
		this.message = message;
	}
	public TestBean() {
		super();
	}
	@Override
	public String toString() {
		return "TestBean [message=" + message + "]";
	}
	
}
