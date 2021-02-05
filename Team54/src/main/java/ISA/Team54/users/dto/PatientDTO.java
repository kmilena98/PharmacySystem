package ISA.Team54.users.dto;

public class PatientDTO {
	private String Name;
	private String Surname;
	
	
	public PatientDTO() {
		super();
	}

	public PatientDTO(String name, String surname) {
		super();
		Name = name;
		Surname = surname;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}
	
	
	
	
}
