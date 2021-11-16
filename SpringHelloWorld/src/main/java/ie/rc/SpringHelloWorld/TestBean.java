package ie.rc.SpringHelloWorld;

public class TestBean {
	
	private String message = "Default Message";
	
	public TestBean() {
		
	}
	
	public TestBean(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "TestBean [message=" + message + "]";
	}
}
