package ISA.Team54.users.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ISA.Team54.exceptions.ValidationExeption;
@Entity
public class Email {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@OneToOne(mappedBy = "email",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private User user;
	
	@Column(unique = false,nullable = true)
	private String email;

	public Email(String email) {
		super();
		this.email = email;
		Validate();
	}
	
	private boolean Validate() {
		/*try {
			if(email == null) {
				throw new ValidationExeption("Email cant be null",error);
			} else if(email.equals("")) {
				throw new ValidationExeption("Email cant be empty");
			} 
		} catch(Exception err) {
			
		}		 */		
		return true;
	}
	
	
}
