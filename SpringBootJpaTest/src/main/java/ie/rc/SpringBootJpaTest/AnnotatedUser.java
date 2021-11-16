package ie.rc.SpringBootJpaTest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode

public class AnnotatedUser {


	private int id;
	private String name;
	private String email;
	private boolean active;
	
	public static void main(String[] args) {
		
		AnnotatedUser u = new AnnotatedUser(1, "Alice", "alice@gmail.com", true);
		
		System.out.println(u);
		
		System.out.println(u.getName());
		System.out.println(u.isActive());
		
		u.setName("Changed");
		
		System.out.println(u);
		
		AnnotatedUser u2 = new AnnotatedUser();
		
		AnnotatedUser u3 = new AnnotatedUser();
		
		System.out.println(u2);
		
		if (u3.equals(u2)) {
			System.out.println("same");
		} else {
			System.out.println("different");
		}
		
		
		
	}
}
